package com.eventproject.productservice.core.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}