package com.ll.exam.springbatchtest.app.cart.service;

import com.ll.exam.springbatchtest.app.member.entity.Member;
import com.ll.exam.springbatchtest.app.cart.entity.CartItem;
import com.ll.exam.springbatchtest.app.cart.repository.CartItemRepository;
import com.ll.exam.springbatchtest.app.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {

    public final CartItemRepository cartItemRepository;

    public CartItem addItem(Member member, ProductOption productOption, int quantity) {
        CartItem oldCartItem = cartItemRepository.findByMemberIdAndProductOptionId(member.getId(), productOption.getId()).orElse(null);

        if ( oldCartItem != null ) {
            oldCartItem.setQuantity(oldCartItem.getQuantity() + quantity);
            cartItemRepository.save(oldCartItem);

            return oldCartItem;
        }
        CartItem cartItem = CartItem.builder()
                .member(member)
                .productOption(productOption)
                .quantity(quantity)
                .build();

        cartItemRepository.save(cartItem);

        return cartItem;
    }
}
