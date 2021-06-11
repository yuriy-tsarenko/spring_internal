package com.example.spring_boot_demo.service;

import com.example.spring_boot_demo.dto.CustomerDto;

public interface CustomerService {


    CustomerDto getCustomerFromDb(Long id);

    CustomerDto createNewCustomer(CustomerDto customerDto);
}
