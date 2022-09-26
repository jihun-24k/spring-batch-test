package com.ll.exam.springbatchtest.product.service;

import com.ll.exam.springbatchtest.product.entity.Product;
import com.ll.exam.springbatchtest.product.entity.ProductOption;
import com.ll.exam.springbatchtest.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void create(String name, int price, String makerShopName, List<ProductOption> options) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .makerShopName(makerShopName)
                .build();

        productRepository.save(product);

        for ( ProductOption option : options ) {
            product.addOption(option);
        }

        productRepository.save(product);
    }
}
