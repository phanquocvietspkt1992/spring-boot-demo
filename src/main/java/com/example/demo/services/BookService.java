package com.example.demo.services;

import com.example.demo.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findOne(Long id);

    boolean isExists(Long id);
    void delete(Long id);

    Book partialUpdate(Book book);
}
