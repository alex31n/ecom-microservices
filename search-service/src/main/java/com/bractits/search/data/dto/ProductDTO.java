package com.bractits.search.data.dto;

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

    private String title;

    private String description;

    private BigDecimal price;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
