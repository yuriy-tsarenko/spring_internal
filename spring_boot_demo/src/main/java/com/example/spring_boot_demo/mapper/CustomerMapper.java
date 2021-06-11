package com.example.spring_boot_demo.mapper;

import com.example.spring_boot_demo.dto.CustomerDto;
import com.example.spring_boot_demo.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto mapEntityToDto(CustomerEntity entity) {
        if (entity != null) {
            CustomerDto dto = new CustomerDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
            return dto;
        }
        return null;
    }

    public CustomerEntity mapDtoToEntity(CustomerDto dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
