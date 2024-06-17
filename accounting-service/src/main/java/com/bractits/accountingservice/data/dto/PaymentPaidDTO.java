package com.bractits.accountingservice.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentPaidDTO {

    @NotNull(message = "Uid Id must not be null")
    private String uid;

    @NotNull(message = "Transaction Id must not be null")
    private String transactionId;

    @NotNull(message = "Amount must not be null")
    private BigDecimal amount;

}
