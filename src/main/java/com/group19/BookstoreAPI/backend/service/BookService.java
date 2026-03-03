package com.group19.BookstoreAPI.backend.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.Book;
import com.group19.BookstoreAPI.backend.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        // For Sprint 2 demo: if DB is empty, we can still return a sample book
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            Book sample = new Book("Demo Book", new BigDecimal("19.99"));
            sample.setGenre("Demo");
            sample.setDescription("Sample book returned for Sprint 2 demo.");
            return List.of(sample);
        }
        return books;
    }
}
