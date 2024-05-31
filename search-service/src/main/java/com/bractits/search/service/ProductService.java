package com.bractits.search.service;

import com.bractits.search.data.dto.ProductDTO;
import com.bractits.search.repository.ProductRepository;
import com.bractits.search.utils.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ProductService {

    private ProductRepository repository;

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    public List<ProductDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .toList();
    }


    @Transactional
    public ProductDTO create(ProductDTO product) {
        log.error("ProductDTO: "+ product);
        log.debug("Debug ProductDTO: "+ product);
        return Stream.of(product)
                .map(mapper::mapToEntity)
                .peek(emp -> emp.setId(null))
                .peek(product1 -> {
                    log.error("mapToEntity Product: "+ product1);
                })
                .map(repository::save)
                .map(mapper::mapToDto)
                .findFirst()
                .orElse(product);
    }
}
