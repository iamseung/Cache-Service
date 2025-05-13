package com.example.cacheservice.service;

import com.example.cacheservice.domain.entity.Product;
import com.example.cacheservice.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCacheService {

    private final ProductJpaRepository productJpaRepository;

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "product", key = "#productId", cacheManager = "localCacheManager")
    public Product findProduct(Long productId) {
        System.out.println("[쿼리 수행] findProduct called with productId = %s".formatted(productId));

        return productJpaRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("상품이 존재하지 않습니다. productId : %s".formatted(productId))
        );
    }
}
