package com.group19.BookstoreAPI.backend.controller;

import com.group19.BookstoreAPI.backend.entity.CartItem;
import com.group19.BookstoreAPI.backend.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add a book to the cart
    @PostMapping("/{cartId}/books/{bookId}")
    public ResponseEntity<CartItem> addBookToCart(@PathVariable Long cartId, @PathVariable Long bookId) {
        CartItem item = cartService.addBookToCart(cartId, bookId);
        return ResponseEntity.ok(item);
    }

    // View all items in the cart
    @GetMapping("/{cartId}")
    public List<CartItem> getCart(@PathVariable Long cartId) {
        return cartService.getCartItems(cartId);
    }
}