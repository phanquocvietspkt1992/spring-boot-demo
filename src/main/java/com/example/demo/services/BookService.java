package com.example.demo.services;

import com.example.demo.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity save(BookEntity book);

    List<BookEntity> findAll();

    Optional<BookEntity> findOne(Long id);

    boolean isExists(Long id);

    BookEntity partialUpdate(Long id, BookEntity bookEntity);
}
