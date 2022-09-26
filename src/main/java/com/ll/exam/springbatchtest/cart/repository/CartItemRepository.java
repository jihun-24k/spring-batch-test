package com.ll.exam.springbatchtest.cart.repository;

import com.ll.exam.springbatchtest.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
