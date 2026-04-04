package com.group19.BookstoreAPI.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.Rating;
import com.group19.BookstoreAPI.backend.repository.RatingRepository;
import com.group19.BookstoreAPI.backend.repository.UserProfileRepository;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserProfileRepository userProfileRepository;

    public RatingService(RatingRepository ratingRepository,
                         UserProfileRepository userProfileRepository) {
        this.ratingRepository = ratingRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public static class CommentResponse {
        public String username;
        public String comment;

        public CommentResponse(String username, String comment) {
            this.username = username;
            this.comment = comment;
        }
    }

    public Rating createRating(Long bookId, Long userId, Double stars, String review) {

        if (bookId == null) throw new IllegalArgumentException("bookId is required");
        if (userId == null) throw new IllegalArgumentException("userId is required");

        if (!userProfileRepository.existsById(userId)) {
            throw new IllegalArgumentException("User does not exist");
        }

        if (ratingRepository.existsByBookIdAndUserId(bookId, userId)) {
            throw new IllegalArgumentException("User already rated this book");
        }

        if (stars == null || stars < 1.0 || stars > 5.0 || (stars * 2) % 1 != 0) {
            throw new IllegalArgumentException("stars must be 1, 1.5, 2, ..., 5");
        }

        Rating rating = new Rating(bookId, userId, stars, review);
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Long userIdFromHeader, Double stars, String review) {

        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rating not found"));

        if (!rating.getUserId().equals(userIdFromHeader)) {
            throw new IllegalArgumentException("You can only update your own rating");
        }

        if (stars == null || stars < 1.0 || stars > 5.0 || (stars * 2) % 1 != 0) {
            throw new IllegalArgumentException("stars must be 1, 1.5, 2, ..., 5");
        }

        rating.setStars(stars);
        rating.setReview(review);

        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsForBook(Long bookId) {
        return ratingRepository.findByBookId(bookId);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public void deleteRating(Long id) {
        if (!ratingRepository.existsById(id)) {
            throw new IllegalArgumentException("Rating not found");
        }
        ratingRepository.deleteById(id);
    }

    public List<CommentResponse> getCommentsForBook(Long bookId) {
        return ratingRepository.findByBookId(bookId)
                .stream()
                .filter(r -> r.getReview() != null && !r.getReview().isEmpty())
                .map(r -> {
                    String username = userProfileRepository.findById(r.getUserId())
                            .map(user -> user.getUsername())
                            .orElse("Unknown");
                    return new CommentResponse(username, r.getReview());
                })
                .toList();
    }

    public Double getAverageRating(Long bookId) {
        List<Rating> ratings = ratingRepository.findByBookId(bookId);

        if (ratings.isEmpty()) return 0.0;

        double sum = ratings.stream()
                .mapToDouble(Rating::getStars)
                .sum();

        double avg = sum / ratings.size();

        return Math.round(avg * 10.0) / 10.0;
    }
}