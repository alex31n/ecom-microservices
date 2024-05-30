package com.bractits.product.utils.event;

import com.bractits.product.data.dto.ProductDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEvent{

    private final UUID id = UUID.randomUUID();

    private final LocalDateTime date = LocalDateTime.now();

    private ProductDTO product;

    private Status status;

}
