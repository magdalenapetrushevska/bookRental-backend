package com.example.bookrental.service;

import com.example.bookrental.model.Author;
import com.example.bookrental.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Long id, String name, String surname, Country country);
    Optional<Author> findById(Long id);
    List<Author> findAll();
}
