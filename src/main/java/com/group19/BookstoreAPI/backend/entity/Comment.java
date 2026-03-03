package com.group19.BookstoreAPI.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false, length = 1000)
    private String text;

    public Comment() {}

    public Comment(Long bookId, String text) {
        this.bookId = bookId;
        this.text = text;
    }

    public Long getId() { return id; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
