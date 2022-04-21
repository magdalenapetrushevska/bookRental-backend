package com.example.bookrental.service.impl;

import com.example.bookrental.model.Author;
import com.example.bookrental.model.Country;
import com.example.bookrental.model.exceptions.AuthorNotFoundException;
import com.example.bookrental.repository.AuthorRepository;
import com.example.bookrental.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Long id, String name, String surname, Country country) {
        return this.authorRepository.save(new Author(id,name, surname, country));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id)));
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
