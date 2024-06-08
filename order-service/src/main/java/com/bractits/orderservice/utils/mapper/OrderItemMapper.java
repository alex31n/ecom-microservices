package com.bractits.orderservice.utils.mapper;

import com.bractits.orderservice.data.dto.OrderItemDTO;
import com.bractits.orderservice.data.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper {

//    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItem toEntity(OrderItemDTO dto);

    OrderItemDTO toDto(OrderItem entity);
}
