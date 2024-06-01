package com.bractits.search.controller;

import com.bractits.search.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

    final private ProductService service;

    /*@GetMapping
    @ResponseBody
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                "find all"
        );
    }*/

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(value = "q", required = false) String query) {

        if (query == null) {
            return ResponseEntity.ok(service.findAll());
        }

        return ResponseEntity.ok(
                service.search(query)
        );
    }

}
