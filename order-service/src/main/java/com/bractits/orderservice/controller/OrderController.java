package com.bractits.orderservice.controller;

import com.bractits.orderservice.data.dto.OrderDTO;
import com.bractits.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
public class OrderController {

    final private OrderService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody OrderDTO requestDTO){
        return ResponseEntity.ok(
                service.create(requestDTO)
        );
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody OrderDTO product){
        return ResponseEntity.ok(
                service.update(id, product)
        );
    }

    @PostMapping("/{id}/cancel")
    @ResponseBody
    public ResponseEntity<?> cancel(@PathVariable Long id){

        return ResponseEntity.ok(
                service.cancelById(id)
        );
    }
}
