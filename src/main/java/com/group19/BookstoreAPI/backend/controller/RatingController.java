package com.group19.BookstoreAPI.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group19.BookstoreAPI.backend.entity.Rating;
import com.group19.BookstoreAPI.backend.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // DTO for request body
    public static class CreateRatingRequest {
        public Long bookId;
        public Integer stars;
        public String review;
    }

    @PostMapping
    public ResponseEntity<?> createRating(@RequestBody CreateRatingRequest req) {
        try {
            Rating created = ratingService.createRating(req.bookId, req.stars, req.review);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/book/{bookId}")
    public List<Rating> getRatingsForBook(@PathVariable Long bookId) {
        return ratingService.getRatingsForBook(bookId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable Long id) {
        try {
            ratingService.deleteRating(id);
            return ResponseEntity.ok("Rating deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}