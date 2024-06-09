package com.bractits.inventoryservice.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InventoryDTO implements Serializable {


    private Long id;

    @NotNull(message = "productId must not be null")
    private Long productId;

    private String productName;

    private LocalDateTime date;

    private int qtyIn;

    private int qtyOut;

    private int sellQty;

    private int returnQty;

    private String reference;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
