package com.bractits.common.event;

import lombok.*;
import lombok.experimental.SuperBuilder;
import com.bractits.common.data.dto.ProductDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductEvent extends BaseEvent{

    private ProductDTO product;

    private Status status;

}
