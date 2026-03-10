package com.group19.BookstoreAPI.backend.service;

import com.group19.BookstoreAPI.backend.entity.CartItem;
import com.group19.BookstoreAPI.backend.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addBookToCart(Long cartId, Long bookId) {
        CartItem item = new CartItem(cartId, bookId);
        return cartItemRepository.save(item);
    }

    public List<CartItem> getCartItems(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }
}
