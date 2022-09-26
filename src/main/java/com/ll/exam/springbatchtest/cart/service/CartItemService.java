package com.ll.exam.springbatchtest.cart.service;

import com.ll.exam.springbatchtest.app.member.entity.Member;
import com.ll.exam.springbatchtest.cart.entity.CartItem;
import com.ll.exam.springbatchtest.cart.repository.CartItemRepository;
import com.ll.exam.springbatchtest.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {

    public final CartItemRepository cartItemRepository;

    public void addItem(Member member, ProductOption productOption, int quantity) {
        CartItem cartItem = CartItem.builder()
                .member(member)
                .productOption(productOption)
                .quantity(quantity)
                .build();

        cartItemRepository.save(cartItem);
    }
}
