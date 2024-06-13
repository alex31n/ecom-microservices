package com.bractits.accountingservice.data.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
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
public class OrderItemDTO {

    private Long id;

//    private Long orderId;

    @NotNull(message = "Item Id must not be null.")
    @Min(value = 1)
    private Long itemId;

    @NotNull(message = "Quantity must not be null.")
    @Min(value = 1)
    private Integer quantity;

    @NotNull(message = "Price must not be null.")
    @DecimalMax("999999.99")
    @DecimalMin("0.0")
    private BigDecimal price;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
