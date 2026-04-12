package com.group19.BookstoreAPI.backend.service;

import org.springframework.stereotype.Service;
import com.group19.BookstoreAPI.backend.entity.Author;
import com.group19.BookstoreAPI.backend.repository.AuthorRepository;
import com.group19.BookstoreAPI.backend.repository.BookRepository;

import com.group19.BookstoreAPI.backend.entity.Book;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    //*****
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

}