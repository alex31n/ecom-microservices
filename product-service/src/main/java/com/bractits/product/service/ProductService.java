package com.bractits.product.service;

import com.bractits.product.data.dto.ProductDTO;
import com.bractits.product.repository.ProductRepository;
import com.bractits.product.utils.ExceptionUtils;
import com.bractits.product.utils.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final ProductPublisher productPublisher;

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    public List<ProductDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .toList();
    }

    @Transactional
    public ProductDTO create(ProductDTO product) {

        return Stream.of(product)
                .peek(emp -> emp.setId(null))
//                .map(mapper::mapToEntity)
//                .map(repository::save)
//                .map(mapper::mapToDto)
                .peek(productPublisher::send)
                .findFirst()
                .orElse(product);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {

        return Stream.ofNullable(id)
                .map(repository::findById)
                .map(product -> product.orElseThrow(() -> ExceptionUtils.notFoundException("Product not found")))
                .peek(product -> {
                    product.setTitle(productDTO.getTitle());
                    product.setDescription(productDTO.getDescription());
                    product.setPrice(productDTO.getPrice());
                })
                .map(repository::save)
                .map(mapper::mapToDto)
                .findFirst()
                .orElse(productDTO);

    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
