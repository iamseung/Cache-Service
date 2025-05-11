package com.example.cacheservice.domain.dto;

import com.example.cacheservice.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRedisEntity {
    private Long id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private LocalDateTime createdAt;

    public static Product from(Product product) {
        return Product.of(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity(), product.getCreatedAt());
    }
}
