package com.example.cacheservice.controller;

import com.example.cacheservice.domain.dto.CreateProductRequest;
import com.example.cacheservice.domain.entity.Product;
import com.example.cacheservice.service.ProductCacheService;
import com.example.cacheservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCacheService productCacheService;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody CreateProductRequest request) {
        productService.createProduct(request.toDto());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{productId}")
    public Product findProduct(@PathVariable Long productId) {
        return productCacheService.findProduct(productId);
    }
}
