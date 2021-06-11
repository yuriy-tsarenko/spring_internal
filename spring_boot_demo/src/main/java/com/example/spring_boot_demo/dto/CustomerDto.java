package com.example.spring_boot_demo.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private Long id;
    private String name;
    private String username;
    private String password;
}
