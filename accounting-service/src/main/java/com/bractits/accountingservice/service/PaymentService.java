package com.bractits.accountingservice.service;

import com.bractits.accountingservice.data.dto.OrderDTO;
import com.bractits.accountingservice.data.dto.PaymentDTO;
import com.bractits.accountingservice.data.dto.PaymentPaidDTO;
import com.bractits.accountingservice.data.entity.Payment;
import com.bractits.accountingservice.repository.PaymentRepository;
import com.bractits.accountingservice.utils.ExceptionUtils;
import com.bractits.accountingservice.utils.event.OrderEvent;
import com.bractits.accountingservice.utils.event.PaymentAction;
import com.bractits.accountingservice.utils.mapper.PaymentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository repository;

    private final PaymentMapper mapper;

    private final PaymentPublisher publisher;


    public List<PaymentDTO> findAll(String transactionId) {

        if (transactionId == null) {
            return repository.findAll().stream().map(mapper::toDto).toList();
        }

        return repository.findAllByTransactionId(transactionId).stream()
                .map(mapper::toDto)
                .toList();
    }

    public PaymentDTO create(PaymentDTO requestDTO) {
        return Stream.of(requestDTO)
                .peek(dto -> dto.setId(null))
                .map(mapper::toEntity)
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
                .findFirst()
                .orElse(requestDTO);
    }

    public PaymentDTO update(Long id, PaymentDTO requestDto) {

        return Stream.ofNullable(id)
                .map(repository::findById)
                .map(obj -> obj.orElseThrow(() -> ExceptionUtils.notFoundException("Payment information not found")))
                .peek(obj -> {
                    obj.setTransactionId(requestDto.getTransactionId());
                    obj.setStatus(requestDto.getStatus());
                })
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
//                .peek(paymentDto -> productPublisher.send(Action.UPDATED, paymentDto))
                .findFirst()
                .orElse(requestDto);

    }

    public void createOrUpdateFromOrderEvent(OrderEvent orderEvent) {

        switch (orderEvent.getAction()) {
            case PLACED -> create(orderDtoToDto(orderEvent.getData(), Payment.Status.WAITING));
            case CANCELLED -> orderCancel(orderEvent);
        }
    }

    public void orderCancel(OrderEvent orderEvent) {

        if (orderEvent == null
                || orderEvent.getData() == null
                || orderEvent.getData().getId() == null) {
            return;
        }

        Payment payment = repository.findByOrderId(orderEvent.getData().getId())
                .orElse(null);

        if (payment == null) {
            return;
        }

        if (payment.getStatus() == Payment.Status.PAID) {
            payment.setStatus(Payment.Status.REFUNDED);
        } else {
            payment.setStatus(Payment.Status.CANCELED);
        }

        repository.save(payment);

    }

    PaymentDTO orderDtoToDto(OrderDTO order, Payment.Status status) {
        return PaymentDTO.builder()
                .orderId(order.getId())
                .amount(order.getAmount())
                .status(status)
                .build();
    }

    public PaymentDTO paymentPaid(PaymentPaidDTO request) {
        return Stream.ofNullable(request)
                .map(PaymentPaidDTO::getUid)
                .map(repository::findByUid)
                .map(obj -> obj.orElseThrow(() -> ExceptionUtils.notFoundException("Payment information not found")))
                .peek(obj -> {

                    if (obj.getAmount().compareTo(request.getAmount()) != 0) {
                        throw ExceptionUtils.badRequestException("Payment amount should be " + obj.getAmount().setScale(0, RoundingMode.HALF_UP));
                    }

                    obj.setTransactionId(request.getTransactionId());
                    obj.setStatus(Payment.Status.PAID);
                })
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
                .peek(paymentDto -> publisher.send(PaymentAction.PAID, paymentDto))
                .findFirst()
                .orElse(null);
    }

    /*public PaymentPaidDTO paymentPaid(PaymentPaidDTO request) {

        PaymentDTO paymentDTO = PaymentDTO.builder()
                .uid(request.getUid())
                .transactionId(request.getTransactionId())
                .amount(request.getAmount())
                .build();

        publisher.send(PaymentAction.PAID, paymentDTO);

        return request;
    }*/
}
