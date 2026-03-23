package com.group19.BookstoreAPI.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.CartItem;
import com.group19.BookstoreAPI.backend.repository.CartItemRepository;

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
//Deletion
    public void removeBookFromCart(Long cartId, Long bookId) {
    List<CartItem> items = cartItemRepository.findByCartId(cartId);

    for (CartItem item : items) {
        if (item.getBookId().equals(bookId)) {
            cartItemRepository.delete(item);
        }
    }
}
}
