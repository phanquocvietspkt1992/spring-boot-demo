package com.example.demo.controllers;

import com.example.demo.domain.dto.BookDto;
import com.example.demo.domain.entities.Book;
import com.example.demo.mappers.Mapper;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    AuthorService authorService;

    final BookService bookService;
    @Autowired
    private Mapper<Book, BookDto> bookMapper;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping(path = "/books")
    public ResponseEntity<BookDto> createUpdateBook(@RequestBody BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
         bookEntity.setId(null);
//        Optional<Author> authorEntity = authorService.findOne(bookDto.getAuthorId());
//        bookEntity.setAuthor(authorEntity.get());
        Book savedBookEntity = bookService.save(bookEntity);
        return new ResponseEntity<>(bookMapper.mapToDTO(savedBookEntity), HttpStatus.CREATED);
    }




}
