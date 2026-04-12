package com.group19.BookstoreAPI.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group19.BookstoreAPI.backend.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}