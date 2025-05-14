package com.example.cacheservice.caching;


import com.example.cacheservice.domain.entity.Product;
import com.example.cacheservice.repository.ProductJpaRepository;
import com.example.cacheservice.service.ProductCacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CacheTest {
    @Autowired private ProductCacheService productCacheService;
    @Autowired private ProductJpaRepository productJpaRepository;
    @Autowired private CacheManager cacheManager;

    @Test
    void testCachingWorks() {
        // given: DB에 미리 저장된 Product가 있다고 가정
        Long productId = 1L;
        Product product = Product.of("A", "AA", 100, 100, LocalDateTime.now());
        productJpaRepository.save(product);

        // when: 첫 번째 호출 (DB 쿼리 발생)
        Product firstCall = productCacheService.findProduct(productId);

        // then: 두 번째 호출 (캐시에서 조회, 쿼리 미발생)
        Product secondCall = productCacheService.findProduct(productId);

        // 검증: 동일 객체인지 비교
        assertThat(secondCall).isEqualTo(firstCall);
    }

    @Test
    void cacheManagerTest() {
        Cache cache = cacheManager.getCache("product");
        System.out.println(cache.toString());
    }
}
