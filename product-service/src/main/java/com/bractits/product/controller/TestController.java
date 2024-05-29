package com.bractits.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @GetMapping
    public ResponseEntity<?> test(@RequestParam(value = "q", required = false) String q) {
        return ResponseEntity.ok("This is the test API!\nPath: "+q+"\n test message: ");
    }
}
