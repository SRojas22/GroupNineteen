package com.group19.BookstoreAPI.backend.service;

import com.group19.BookstoreAPI.backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // TODO: Replace Object with Book once entity exists
    public List<Object> getAllBooks() {
        return bookRepository.findAll();
    }

    // TODO: Add sorting/filtering logic later (Sprint 3+)
}

