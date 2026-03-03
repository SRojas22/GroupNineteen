package com.group19.BookstoreAPI.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.Comment;
import com.group19.BookstoreAPI.backend.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Long bookId, String text) {
        if (bookId == null) throw new IllegalArgumentException("bookId is required");
        if (text == null || text.trim().isEmpty()) throw new IllegalArgumentException("text is required");

        Comment comment = new Comment(bookId, text.trim());
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForBook(Long bookId) {
        return commentRepository.findByBookId(bookId);
    }
}