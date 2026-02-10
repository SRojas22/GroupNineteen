package com.group19.BookstoreAPI.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Replace Object with Author once Author entity is created
@Repository
public interface AuthorRepository extends JpaRepository<Object, Long> {
    // Spring Data JPA auto-generates methods like:
    // findAll(), findById(), save(), deleteById()
}

