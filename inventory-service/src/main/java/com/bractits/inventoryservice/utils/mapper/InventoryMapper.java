package com.bractits.inventoryservice.utils.mapper;

import com.bractits.inventoryservice.data.dto.InventoryDTO;
import com.bractits.inventoryservice.data.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    Inventory toEntity(InventoryDTO dto);

    InventoryDTO toDto(Inventory entity);
}
