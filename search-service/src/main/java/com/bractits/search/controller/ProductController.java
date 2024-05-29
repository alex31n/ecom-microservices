package com.bractits.search.controller;

import com.bractits.search.data.dto.ProductDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

//    final private ProductService service;

    /*@GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                service.findAll()
        );
    }*/

    /*@PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody ProductDTO product){
        return ResponseEntity.ok(
                service.create(product)
        );
    }*/

    /*@PutMapping("/{id}")
    @ResponseBody

    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductDTO product){
        return ResponseEntity.ok(
                service.update(id, product)
        );
    }*/
}
