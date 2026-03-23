package com.group19.BookstoreAPI.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenreContainingIgnoreCase(String genre);
}
