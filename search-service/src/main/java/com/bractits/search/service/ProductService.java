package com.bractits.search.service;

import com.bractits.search.data.dto.ProductDTO;
import com.bractits.search.repository.ProductRepository;
import com.bractits.search.utils.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    private ProductRepository repository;

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    public List<ProductDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .toList();
    }



}
