package com.bractits.accountingservice.controller;

import com.bractits.accountingservice.data.dto.PaymentPaidDTO;
import com.bractits.accountingservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService service;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) String transactionId) {

        return ResponseEntity.ok(service.findAll(transactionId));
    }

    /*@PostMapping
    public ResponseEntity<?> create(@RequestBody PaymentDTO request) {
        return ResponseEntity.ok(service.create(request));
    }*/

    @PostMapping("/paid")
    public ResponseEntity<?> paymentPaid(@RequestBody PaymentPaidDTO request) {
        return ResponseEntity.ok(service.paymentPaid(request));
    }


}
