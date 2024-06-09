package com.bractits.accountingservice.data.dto;

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
@Entity
@Table(name = "account")
public class PaymentDTO {

    public enum Status{
        SUCCESS, FAILED
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Transaction Id must not be null")
    private UUID transactionId;

    @NotNull(message = "order Id must not be null")
    private Long orderId;

    @NotNull(message = "Amount must not be null")
    private BigDecimal amount;

    @NotNull(message = "Status must not be null")
    private Status status;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
