package com.bractits.search.data.event;

import com.bractits.search.data.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent{

    private UUID id;

    private LocalDateTime date;

    private ProductDTO product;

    private Action action;

    private Status status;

}
