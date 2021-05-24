package com.example.lesson1.mapper;

import com.example.lesson1.dto.ProductDto;
import com.example.lesson1.entity.ProductEntity;

import java.util.List;

public interface ProductMapper {

    ProductDto mapEntityToDto(ProductEntity entity);

    List<ProductDto> mapEntitiesToDto(List<ProductEntity> entity);
}
