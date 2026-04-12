package com.group19.BookstoreAPI.backend.controller;
import com.group19.BookstoreAPI.backend.entity.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group19.BookstoreAPI.backend.entity.Author;
import com.group19.BookstoreAPI.backend.service.AuthorService;
import com.group19.BookstoreAPI.backend.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author saved = authorService.saveAuthor(author);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable Long id) {
        List<Book> books = bookService.getBooksByAuthorId(id);
        return ResponseEntity.ok(books);
    }

}