package com.example.spring_boot_demo.controller;

import com.example.spring_boot_demo.dto.CustomerDto;
import com.example.spring_boot_demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class DemoController {

    private final CustomerService service;

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return service.getCustomerFromDb(id);
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto dto) {
        return service.createNewCustomer(dto);
    }
}
