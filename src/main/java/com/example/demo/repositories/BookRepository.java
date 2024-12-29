package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.entities.BookEntity;

public interface BookRepository  extends JpaRepository<BookEntity, Long> {
}