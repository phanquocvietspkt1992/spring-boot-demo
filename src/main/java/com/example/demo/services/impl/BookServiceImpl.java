package com.example.demo.services.impl;

import com.example.demo.domain.entities.AuthorEntity;
import com.example.demo.domain.entities.BookEntity;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public BookEntity save(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<BookEntity> findOne(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public BookEntity partialUpdate(Long id, BookEntity bookEntity) {
        return null;
    }
}
