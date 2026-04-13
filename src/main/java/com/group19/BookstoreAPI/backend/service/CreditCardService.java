package com.group19.BookstoreAPI.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.CreditCard;
import com.group19.BookstoreAPI.backend.entity.UserProfile;
import com.group19.BookstoreAPI.backend.repository.CreditCardRepository;
import com.group19.BookstoreAPI.backend.repository.UserProfileRepository;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final UserProfileRepository userProfileRepository;

    public CreditCardService(CreditCardRepository creditCardRepository, UserProfileRepository userProfileRepository) {
        this.creditCardRepository = creditCardRepository;
        this.userProfileRepository = userProfileRepository;
    }

    // CREATE CREDIT CARD FOR A USER
    public Optional<CreditCard> createCreditCard(String username, CreditCard creditCard) {
        Optional<UserProfile> userOpt = userProfileRepository.findByUsername(username);
        if (userOpt.isEmpty()) return Optional.empty();
        creditCard.setUserProfile(userOpt.get());
        return Optional.of(creditCardRepository.save(creditCard));
    }
}
