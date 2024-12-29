package com.example.demo.services.impl;

import com.example.demo.domain.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);

    }

    @Override
    public List<Author> findAll() {
       return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findOne(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public Author partialUpdate(Long id, Author authorEntity) {
        // Fetch the user by ID
        Optional<Author> optionalUser = authorRepository.findById(id);

        if (optionalUser.isPresent()) {
            // Get the existing user
            Author author = optionalUser.get();

            // Update the fields
            author.setName(authorEntity.getName());
            author.setAge(authorEntity.getAge());

            // Save the updated user
            return authorRepository.save(author);
        } else {
            // Handle the case where the user doesn't exist
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
    authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAuthorsByAgeGreaterThan(int age) {
        return authorRepository.findAuthorsByAgeGreaterThan(age);
    }
}
