package com.bractits.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Profile("dev")
@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public ResponseEntity<?> test(@RequestParam(value = "q", required = false) String q) {
        return ResponseEntity.ok("This is the "+appName+" test API!\nPath: "+q+"\n test message: ");
    }
}
