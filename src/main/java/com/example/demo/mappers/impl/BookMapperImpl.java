package com.example.demo.mappers.impl;

import com.example.demo.domain.dto.BookDto;
import com.example.demo.domain.entities.Book;
import com.example.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<Book, BookDto> {

    private ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(Book bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public Book mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }
}