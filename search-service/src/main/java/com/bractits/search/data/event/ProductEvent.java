package com.bractits.search.data.event;

import com.bractits.search.data.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Action action;

    private Status status;

}
