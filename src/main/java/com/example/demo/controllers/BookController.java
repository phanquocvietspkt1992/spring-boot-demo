package com.example.demo.controllers;

import com.example.demo.domain.dto.BookDto;
import com.example.demo.domain.entities.Book;
import com.example.demo.mappers.Mapper;
import com.example.demo.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    final BookService bookService;

    private Mapper<Book, BookDto> bookMapper;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping(path = "/books")
    public ResponseEntity<BookDto> createUpdateBook(@RequestBody BookDto bookDto) {
        Book bookEntity = bookMapper.mapFrom(bookDto);
        Book savedBookEntity = bookService.save(bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }

}
