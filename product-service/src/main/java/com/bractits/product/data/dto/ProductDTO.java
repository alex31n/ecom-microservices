package com.bractits.product.data.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
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

public class ProductDTO {

    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    @Size(max = 55)
    @NotBlank(message = "Title must be empty.")
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull(message = "Price must not be null.")
    @DecimalMax("999999.99")
    @DecimalMin("0.0")
    private BigDecimal price;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
