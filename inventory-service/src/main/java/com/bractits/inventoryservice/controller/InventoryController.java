package com.bractits.inventoryservice.controller;

import com.bractits.inventoryservice.data.dto.InventoryDTO;
import com.bractits.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public ResponseEntity<List<InventoryDTO>> findByProductId(@RequestParam(required = false) Long productId) {
        return ResponseEntity.ok(service.findAll(productId));
    }

    @PostMapping
    public ResponseEntity<InventoryDTO> create(@RequestBody InventoryDTO inventory) {
        return ResponseEntity.ok(service.create(inventory));
    }



}
