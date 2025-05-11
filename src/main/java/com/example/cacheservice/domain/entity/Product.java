package com.example.cacheservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private LocalDateTime createdAt;

    private Product(String name, String description, int price, int quantity, LocalDateTime createdAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    private Product(Long id, String name, String description, int price, int quantity, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public static Product of(String name, String description, int price, int quantity, LocalDateTime createdAt) {
        return new Product(name, description, price, quantity, createdAt);
    }

    public static Product of(Long id, String name, String description, int price, int quantity, LocalDateTime createdAt) {
        return new Product(id, name, description, price, quantity, createdAt);
    }
}
