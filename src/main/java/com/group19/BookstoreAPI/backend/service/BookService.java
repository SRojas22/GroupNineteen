package com.group19.BookstoreAPI.backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.group19.BookstoreAPI.backend.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import com.group19.BookstoreAPI.backend.entity.Author;

import com.group19.BookstoreAPI.backend.entity.Book;
import com.group19.BookstoreAPI.backend.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // CREATE
    public Book saveBook(Book book) {
        Long authorId = book.getAuthor().getId();

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);

        return bookRepository.save(book);
    }

    // GET ALL
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            Book sample = new Book("Demo Book", new BigDecimal("19.99"));
            sample.setAuthor(null);
            sample.setGenre("Demo");
            sample.setDescription("Sample book returned for Sprint 2 demo.");

            sample.setIsbn("ISBN 978-0-306-40615-7");
            sample.setPublisher("Penguin Random House");
            sample.setYearPublished(2012);
            sample.setCopiesSold(20000);
            return List.of(sample);
        }

        return books;
    }

    // GET BY ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
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
        book.setIsbn(bookDetails.getIsbn());
        book.setPublisher(bookDetails.getPublisher());
        book.setYearPublished(bookDetails.getYearPublished());
        book.setCopiesSold(bookDetails.getCopiesSold());

        return bookRepository.save(book);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}