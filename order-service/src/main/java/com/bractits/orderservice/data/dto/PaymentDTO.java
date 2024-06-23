package com.bractits.orderservice.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {

    public enum Status{
        WAITING,
        SUCCESS,
        FAILED,
        REFUNDED
    }


    private Long id;

    @NotNull(message = "Uid Id must not be null")
    private String uid;

    private String transactionId;

    @NotNull(message = "order Id must not be null")
    private Long orderId;

    @NotNull(message = "Amount must not be null")
    private BigDecimal amount;

    @NotNull(message = "Status must not be null")
    private Status status;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
