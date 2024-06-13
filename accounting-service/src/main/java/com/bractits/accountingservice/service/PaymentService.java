package com.bractits.accountingservice.service;


import com.bractits.accountingservice.data.dto.PaymentDTO;
import com.bractits.accountingservice.repository.PaymentRepository;
import com.bractits.accountingservice.utils.event.OrderEvent;
import com.bractits.accountingservice.utils.mapper.PaymentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository repository;

    private final PaymentMapper mapper;


    public List<PaymentDTO> findAll(UUID transactionId) {

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

    public void createOrUpdateFromOrderEvent(OrderEvent orderEvent) {

    }
}
