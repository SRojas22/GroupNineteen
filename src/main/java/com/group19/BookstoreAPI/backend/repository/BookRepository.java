package com.group19.BookstoreAPI.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: Replace Object with Book once Book entity is created
@Repository
public interface BookRepository extends JpaRepository<Object, Long> {
}


