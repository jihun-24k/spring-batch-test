package com.ll.exam.springbatchtest.product.service;

import com.ll.exam.springbatchtest.product.entity.Product;
import com.ll.exam.springbatchtest.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void create(String name, int price, String makerShopName) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .makerShopName(makerShopName)
                .build();

        productRepository.save(product);
    }
}
