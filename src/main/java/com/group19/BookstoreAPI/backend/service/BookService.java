package com.group19.BookstoreAPI.backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group19.BookstoreAPI.backend.entity.Book;
import com.group19.BookstoreAPI.backend.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // GET ALL
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            Book sample = new Book("Demo Book", "Demo Author", new BigDecimal("19.99"));
            sample.setGenre("Demo");
            sample.setDescription("Sample book returned for Sprint 2 demo.");
            return List.of(sample);
        }

        return books;
    }

    // GET BY ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // GET BY GENRE ✅ (NEW)
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenreContainingIgnoreCase(genre);
    }

    // DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // UPDATE
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setDescription(bookDetails.getDescription());
        book.setPrice(bookDetails.getPrice());
        book.setGenre(bookDetails.getGenre());

        return bookRepository.save(book);
    }
}