package com.example.cacheservice.service;

import com.example.cacheservice.domain.dto.ProductDto;
import com.example.cacheservice.domain.entity.Product;
import com.example.cacheservice.repository.ProductJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductJpaRepository productJpaRepository;

    @Transactional
    public Product createProduct(ProductDto dto) {
        return productJpaRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public Product findProductById(Long productId) {
        return productJpaRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("상품이 존재하지 않습니다. productId : %s".formatted(productId))
        );
    }
}
