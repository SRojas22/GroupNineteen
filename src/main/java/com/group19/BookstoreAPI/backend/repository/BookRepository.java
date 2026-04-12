package com.group19.BookstoreAPI.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group19.BookstoreAPI.backend.entity.Book;

import java.util.Optional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    List<Book> findByAuthorId(Long authorId);
}
    List<Book> findByGenreContainingIgnoreCase(String genre);
}
