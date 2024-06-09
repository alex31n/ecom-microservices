package com.bractits.inventoryservice.service;

import com.bractits.inventoryservice.data.dto.InventoryDTO;
import com.bractits.inventoryservice.repository.InventoryRepository;
import com.bractits.inventoryservice.utils.mapper.InventoryMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository repository;

    private final InventoryMapper mapper;


    public List<InventoryDTO> findAll(Long productId) {

        if (productId == null) {
            return repository.findAll().stream()
                    .map(mapper::toDto)
                    .toList();
        }

        return repository.findByProductId(productId).stream()
                .map(mapper::toDto)
                .toList();
    }


    /*public InventoryDTO create(InventoryDTO inventoryDTO) {

        return Stream.of(inventoryDTO)
                .map(mapper::toEntity)
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
                .findFirst()
                .orElse(inventoryDTO);
    }*/


    public InventoryDTO create(InventoryDTO inventoryDTO) {

        return Stream.of(inventoryDTO)
                .peek(dto-> dto.setId(null))
                .map(mapper::toEntity)
                .map(repository::saveAndFlush)
                .map(mapper::toDto)
                .findFirst()
                .orElse(inventoryDTO);
    }


}
