package com.example.lesson1.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {


    private String productCode;

    private String productName;

    private String productLine;

    private String productScale;

    private String productVendor;

    private String productDescription;

    private Integer quantityInStock;

    private BigDecimal buyPrice;

    private BigDecimal msrp;
}
