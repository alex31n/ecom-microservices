package com.bractits.product.utils.mapper;

import com.bractits.product.data.dto.ProductDTO;
import com.bractits.product.data.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapToEntity(ProductDTO dto);

    ProductDTO mapToDto(Product entity);
}
