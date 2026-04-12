package com.group19.BookstoreAPI.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group19.BookstoreAPI.backend.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByBookId(Long bookId);

    boolean existsByBookIdAndUserId(Long bookId, Long userId);
}