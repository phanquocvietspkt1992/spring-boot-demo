package com.example.demo.controllers;

import com.example.demo.domain.dto.AuthorDto;
import com.example.demo.domain.dto.BookDto;
import com.example.demo.domain.entities.Author;
import com.example.demo.domain.entities.Book;
import com.example.demo.mappers.Mapper;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    private Mapper<Book, BookDto> bookMapper;

    @PostMapping
    public ResponseEntity<BookDto> createUpdateBook(@RequestBody BookDto bookDto) {
        Book bookEntity = bookMapper.mapToEntity(bookDto);
         bookEntity.setId(null);

        Book savedBookEntity = bookService.save(bookEntity);
        return new ResponseEntity<>(bookMapper.mapToDTO(savedBookEntity), HttpStatus.CREATED);
    }
@GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
            List<Book> books = bookService.findAll();
            List<BookDto> bookDtos = books.stream().map(bookMapper::mapToDTO).collect(Collectors.toList());
           return new ResponseEntity<>(bookDtos, HttpStatus.OK);
        }




}
