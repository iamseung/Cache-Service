package com.example.cacheservice.domain.dto;

import com.example.cacheservice.domain.entity.Product;

import java.time.LocalDateTime;

public class ProductDto {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public  Product toEntity() {
        return Product.of(name, description, price, quantity, createdAt, modifiedAt);
    }
}
