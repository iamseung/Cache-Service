package com.example.cacheservice.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private String description;
    private int price;
    private int quantity;

    public ProductDto toDto() {
        return new ProductDto(name, description, price, quantity, LocalDateTime.now());
    }
}
