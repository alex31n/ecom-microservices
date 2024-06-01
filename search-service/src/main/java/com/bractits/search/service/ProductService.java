package com.bractits.search.service;

import com.bractits.search.data.dto.ProductDTO;
import com.bractits.search.repository.ProductRepository;
import com.bractits.search.utils.ExceptionUtils;
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

    public List<ProductDTO> search(String query) {

        return repository.search(query)
                .stream()
                .map(mapper::mapToDto)
                .toList();
    }

    public List<ProductDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .toList();
    }


    @Transactional
    public ProductDTO create(ProductDTO product) {
        return Stream.of(product)
                .map(mapper::mapToEntity)
                .peek(emp -> emp.setId(null))
                .map(repository::save)
                .map(mapper::mapToDto)
                .findFirst()
                .orElse(product);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        return Stream.ofNullable(id)
                .map(repository::findByProductId)
                .map(product -> product.orElseThrow(() -> ExceptionUtils.notFoundException("Product not found")))
                .peek(product -> {
                    product.setTitle(productDTO.getTitle());
                    product.setDescription(productDTO.getDescription());
                    product.setPrice(productDTO.getPrice());
                })
                .map(repository::saveAndFlush)
                .map(mapper::mapToDto)
                .findFirst()
                .orElse(productDTO);

    }

    public void deleteByProductId(Long id) {
        repository.deleteByProductId(id);
    }
}
