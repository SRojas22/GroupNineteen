package com.group19.BookstoreAPI.backend.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group19.BookstoreAPI.backend.entity.CartItem;
import com.group19.BookstoreAPI.backend.service.CartService;

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

    // Remove a book from the cart
    @DeleteMapping("/{cartId}/books/{bookId}")
        public ResponseEntity<Void> removeBookFromCart(@PathVariable Long cartId, @PathVariable Long bookId) {
        cartService.removeBookFromCart(cartId, bookId);
        return ResponseEntity.noContent().build();
    }
    //returns total price
    @GetMapping("/{cartId}/subtotal")
        public BigDecimal getSubtotal(@PathVariable Long cartId) {
        return cartService.calculateSubtotal(cartId);
    }
}
