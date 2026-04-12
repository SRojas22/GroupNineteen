package com.group19.BookstoreAPI.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group19.BookstoreAPI.backend.entity.Rating;
import com.group19.BookstoreAPI.backend.service.RatingService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    public static class CreateRatingRequest {

        @Schema(example = "1")
        public Long bookId;

        @Schema(example = "7")
        public Long userId;

        @Schema(
                description = "Rating must be between 1 and 5 in 0.5 increments",
                example = "2.5",
                allowableValues = {"1","1.5","2","2.5","3","3.5","4","4.5","5"}
        )
        public Double stars;

        @Schema(example = "Really enjoyed this book")
        public String review;
    }

    public static class UpdateRatingRequest {

        @Schema(
                description = "Rating must be between 1 and 5 in 0.5 increments",
                example = "3.5",
                allowableValues = {"1","1.5","2","2.5","3","3.5","4","4.5","5"}
        )
        public Double stars;

        @Schema(example = "Changed my mind after finishing it")
        public String review;
    }

    @PostMapping
    public ResponseEntity<?> createRating(@RequestBody CreateRatingRequest req) {
        try {
            Rating created = ratingService.createRating(
                    req.bookId,
                    req.userId,
                    req.stars,
                    req.review
            );
            return ResponseEntity.status(201).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRating(
            @PathVariable Long id,

            @Parameter(description = "User ID (simulated authentication)", example = "7", required = true)
            @RequestHeader("X-User-Id") Long userId,

            @RequestBody UpdateRatingRequest req) {

        try {
            Rating updated = ratingService.updateRating(
                    id,
                    userId,
                    req.stars,
                    req.review
            );
            return ResponseEntity.ok(updated);
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

    @GetMapping("/book/{bookId}/comments")
    public List<RatingService.CommentResponse> getCommentsForBook(@PathVariable Long bookId) {
        return ratingService.getCommentsForBook(bookId);
    }

    @GetMapping("/book/{bookId}/average")
    public Double getAverageRating(@PathVariable Long bookId) {
        return ratingService.getAverageRating(bookId);
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