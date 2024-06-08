package com.bractits.orderservice.utils.mapper;

import com.bractits.orderservice.data.dto.OrderDTO;
import com.bractits.orderservice.data.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDTO dto);

    OrderDTO toDto(Order entity);
}
