package com.example.lesson1.mapper;

import com.example.lesson1.dto.ProductDto;
import com.example.lesson1.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto mapEntityToDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setProductCode(entity.getProductCode());
        dto.setProductName(entity.getProductName());
        dto.setProductLine(entity.getProductLine());
        dto.setProductScale(entity.getProductScale());
        dto.setProductVendor(entity.getProductVendor());
        dto.setProductDescription(entity.getProductDescription());
        dto.setQuantityInStock(entity.getQuantityInStock());
        dto.setBuyPrice(entity.getBuyPrice());
        dto.setMsrp(entity.getMsrp());
        return dto;
    }

    @Override
    public List<ProductDto> mapEntitiesToDto(List<ProductEntity> entities) {
        return entities.parallelStream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
