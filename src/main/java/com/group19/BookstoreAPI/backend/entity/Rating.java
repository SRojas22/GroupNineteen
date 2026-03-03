package com.group19.BookstoreAPI.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Keep it simple: store the book id (no relations needed for sprint)
    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private Integer stars; // 1..5

    @Column(length = 1000)
    private String review; // optional text

    public Rating() {}

    public Rating(Long bookId, Integer stars, String review) {
        this.bookId = bookId;
        this.stars = stars;
        this.review = review;
    }

    public Long getId() { return id; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Integer getStars() { return stars; }
    public void setStars(Integer stars) { this.stars = stars; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }
}