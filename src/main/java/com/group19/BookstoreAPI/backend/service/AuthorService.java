package com.group19.BookstoreAPI.backend.service;

import com.group19.BookstoreAPI.backend.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer = business logic layer
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    // Constructor injection (recommended Spring practice)
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // TODO: Replace Object with Author once entity exists
    public List<Object> getAllAuthors() {
        return authorRepository.findAll();
    }

    // TODO: Add create/update/delete logic once requirements are finalized
}


