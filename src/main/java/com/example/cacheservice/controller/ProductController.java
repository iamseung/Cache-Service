package com.example.cacheservice.controller;

import com.example.cacheservice.domain.dto.CreateProductRequest;
import com.example.cacheservice.domain.entity.Product;
import com.example.cacheservice.service.ProductCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCacheService productCacheService;

    @PostMapping
    public void createProduct(CreateProductRequest request) {
        request.toDto();
    }

    @GetMapping("/{productId}")
    public Product findProduct(@PathVariable Long productId) {
        return productCacheService.findProduct(productId);
    }
}
