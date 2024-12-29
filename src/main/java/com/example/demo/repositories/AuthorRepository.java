package com.example.demo.repositories;
import com.example.demo.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.entities.BookEntity;

public interface AuthorRepository  extends JpaRepository<AuthorEntity, Long> {
}