package com.group19.BookstoreAPI.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group19.BookstoreAPI.backend.entity.CreditCard;
import com.group19.BookstoreAPI.backend.service.CreditCardService;

@RestController
@RequestMapping("/profiles")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    // POST /profiles/{username}/cards - Add credit card to a user
    @PostMapping("/{username}/cards")
    public ResponseEntity<Void> addCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        boolean created = creditCardService.createCreditCard(username, creditCard).isPresent();
        return created ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.notFound().build();
    }
}
