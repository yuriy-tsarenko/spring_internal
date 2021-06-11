package com.example.spring_boot_demo.service;

import com.example.spring_boot_demo.dto.CustomerDto;
import com.example.spring_boot_demo.mapper.CustomerMapper;
import com.example.spring_boot_demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public CustomerDto getCustomerFromDb(Long id) {
        return mapper.mapEntityToDto(repository.findCustomerEntityById(id));
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {
        return mapper.mapEntityToDto(repository.save(mapper.mapDtoToEntity(customerDto)));
    }
}
