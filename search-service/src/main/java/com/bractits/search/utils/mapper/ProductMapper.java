package com.bractits.search.utils.mapper;


import com.bractits.search.data.dto.ProductDTO;
import com.bractits.search.data.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "id", target = "productId")
    Product mapToEntity(ProductDTO dto);

    @Mapping(source = "productId", target = "id")
    ProductDTO mapToDto(Product entity);
}
