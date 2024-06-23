package com.bractits.inventoryservice.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    public enum Status {
        PLACED,
        CANCELLED,
        PAYMENT_SUCCESS,
        PAYMENT_FAILED,
        SHIPPED,
        DELIVERED,
        REFUNDED
    }

    private Long id;

    private Long userId;

    private BigDecimal amount;

    @NotBlank(message = "Shipping Address must not be empty.")
    private String shippingAddress;

    @NotNull(message = "Order Date must not be null.")
    private LocalDateTime orderDate;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private Status status;

    private UUID paymentId;

    private UUID shippedId;

    private List<OrderItemDTO> items= new ArrayList<>();
}
