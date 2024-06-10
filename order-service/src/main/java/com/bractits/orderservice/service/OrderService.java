package com.bractits.orderservice.service;


import com.bractits.orderservice.data.dto.OrderDTO;
import com.bractits.orderservice.data.entity.Order;
import com.bractits.orderservice.repository.OrderItemRepository;
import com.bractits.orderservice.repository.OrderRepository;
import com.bractits.orderservice.utils.ExceptionUtils;
import com.bractits.orderservice.utils.mapper.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository repository;
    private final OrderItemRepository orderItemRepository;

    private final OrderMapper mapper;

    public List<OrderDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public OrderDTO create(OrderDTO request) {
        return Stream.of(request)
                .map(mapper::toEntity)
                .map(repository::save)
                .peek(order -> {
                    if (order.getId() != null) {
                        order.getItems().forEach(orderItem -> orderItem.setOrderId(order.getId()));
                        orderItemRepository.saveAll(order.getItems());
                    } else {
                        throw ExceptionUtils.badRequestException("Order is created!");
                    }
                })
                .map(mapper::toDto)
//                .peek(product -> productPublisher.send(Action.CREATED, product))
                .findFirst()
                .orElse(request);
    }

    public OrderDTO cancelById(Long id) {
        return updateStatus(id, Order.Status.CANCELLED);
    }

    public OrderDTO updateStatus(Long id, Order.Status status) {

        return Stream.ofNullable(id)
                .map(repository::findById)
                .map(order -> order.orElseThrow(() -> ExceptionUtils.notFoundException("Order not found")))
                .peek(order -> {
                    order.setStatus(status);
                })
                .map(repository::save)
                .map(mapper::toDto)
//                .peek(product -> productPublisher.send(Action.UPDATED, product))
                .findFirst()
                .orElse(null);

    }

    public OrderDTO update(Long id, OrderDTO request) {

        return Stream.ofNullable(id)
                .map(repository::findById)
                .map(order -> order.orElseThrow(() -> ExceptionUtils.notFoundException("Order not found")))
                .peek(order -> {
//                    order.setTitle(request.getTitle());
//                    order.setDescription(request.getDescription());
//                    order.setPrice(request.getPrice());
                })
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
//                .peek(product -> productPublisher.send(Action.UPDATED, product))
                .findFirst()
                .orElse(request);

    }


}
