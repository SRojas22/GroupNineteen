package com.group19.BookstoreAPI.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group19.BookstoreAPI.backend.entity.Comment;
import com.group19.BookstoreAPI.backend.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public static class AddCommentRequest {
        public Long bookId;
        public String text;
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody AddCommentRequest req) {
        try {
            Comment created = commentService.addComment(req.bookId, req.text);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/book/{bookId}")
    public List<Comment> getCommentsForBook(@PathVariable Long bookId) {
        return commentService.getCommentsForBook(bookId);
    }
}