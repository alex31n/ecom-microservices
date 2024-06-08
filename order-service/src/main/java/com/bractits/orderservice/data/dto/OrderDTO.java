package com.bractits.orderservice.data.dto;

import com.bractits.orderservice.data.entity.OrderItem;
import jakarta.persistence.*;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private String orderNo;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private BigDecimal amount;

    @NotBlank(message = "Shipping Address must not be empty.")
    private String shippingAddress;

    @NotNull(message = "Order Date must not be null.")
    private LocalDateTime orderDate;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private List<OrderItem> items=new ArrayList<>();
}
