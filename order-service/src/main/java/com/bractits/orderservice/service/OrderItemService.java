package com.bractits.orderservice.service;


import com.bractits.orderservice.data.dto.OrderItemDTO;
import com.bractits.orderservice.repository.OrderItemRepository;
import com.bractits.orderservice.utils.ExceptionUtils;
import com.bractits.orderservice.utils.mapper.OrderItemMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class OrderItemService {

    private final OrderItemRepository repository;

    private final OrderItemMapper mapper;

    public List<OrderItemDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<OrderItemDTO> findAllByOrderId(Long orderId) {

        return repository.findByOrderId(orderId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public OrderItemDTO create(OrderItemDTO productDTO) {
        return Stream.of(productDTO)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::toDto)
                .findFirst()
                .orElse(productDTO);
    }

    public OrderItemDTO update(Long id, OrderItemDTO request) {

        return Stream.ofNullable(id)
                .map(repository::findById)
                .map(order -> order.orElseThrow(() -> ExceptionUtils.notFoundException("Order Item not found")))
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
                .findFirst()
                .orElse(request);

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
