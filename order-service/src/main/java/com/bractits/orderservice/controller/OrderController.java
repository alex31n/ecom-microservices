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
    public ResponseEntity<?> create(@Valid @RequestBody OrderDTO product){
        return ResponseEntity.ok(
                service.create(product)
        );
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody OrderDTO product){
        return ResponseEntity.ok(
                service.update(id, product)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
