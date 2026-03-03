package com.group19.BookstoreAPI.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.Rating;
import com.group19.BookstoreAPI.backend.repository.RatingRepository;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating createRating(Long bookId, Integer stars, String review) {
        if (bookId == null) throw new IllegalArgumentException("bookId is required");
        if (stars == null || stars < 1 || stars > 5) throw new IllegalArgumentException("stars must be 1-5");

        Rating rating = new Rating(bookId, stars, review);
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsForBook(Long bookId) {
        return ratingRepository.findByBookId(bookId);
    }
}