package com.example.demo.repositories;
import com.example.demo.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository  extends JpaRepository<Author, Long> {
    // Custom query to find authors older than a given age
    @Query("SELECT a FROM Author a WHERE a.age > :age")
    List<Author> findAuthorsByAgeGreaterThan(@Param("age") int age);

    @Query("SELECT a FROM Author a WHERE UPPER(a.name) LIKE CONCAT('%', UPPER(:name), '%')")
    List<Author> findAuthorsByName(String name);
}