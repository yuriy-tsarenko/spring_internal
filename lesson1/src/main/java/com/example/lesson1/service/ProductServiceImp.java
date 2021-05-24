package com.example.lesson1.service;

import com.example.lesson1.dto.ProductDto;
import com.example.lesson1.mapper.ProductMapper;
import com.example.lesson1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        return productMapper.mapEntitiesToDto(productRepository.findAll());
    }
}
