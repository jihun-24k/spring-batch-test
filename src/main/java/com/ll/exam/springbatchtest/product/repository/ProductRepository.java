package com.ll.exam.springbatchtest.product.repository;

import com.ll.exam.springbatchtest.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
