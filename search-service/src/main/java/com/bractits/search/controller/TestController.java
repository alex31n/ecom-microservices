package com.bractits.search.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @GetMapping
    public ResponseEntity<?> test(@RequestParam(value = "q", required = false) String q) {
        return ResponseEntity.ok("This is the Search test API!\nPath: "+q+"\ntest message: ");
    }
}
