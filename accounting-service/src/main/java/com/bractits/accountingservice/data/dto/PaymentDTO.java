package com.bractits.accountingservice.data.dto;

import com.bractits.accountingservice.data.entity.Payment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {

    /*public enum Status{
        WAITING,
        SUCCESS,
        FAILED,
        REFUNDED
    }*/


    private Long id;

    @NotNull(message = "Uid Id must not be null")
    private String uid;

    private String transactionId;

    @NotNull(message = "order Id must not be null")
    private Long orderId;

    @NotNull(message = "Amount must not be null")
    private BigDecimal amount;

    @NotNull(message = "Status must not be null")
    private Payment.Status status;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
