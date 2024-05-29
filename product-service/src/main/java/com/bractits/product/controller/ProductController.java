package com.bractits.product.controller;

import com.bractits.product.data.dto.ProductDTO;
import com.bractits.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

    final private ProductService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> create(@Valid @RequestBody ProductDTO product){
        return ResponseEntity.ok(
                service.create(product)
        );
    }
}
