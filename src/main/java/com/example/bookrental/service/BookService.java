package com.example.bookrental.service;

import com.example.bookrental.model.Book;
import com.example.bookrental.model.dto.BookDto;
import com.example.bookrental.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    void deleteById(Long id);
    Optional<Book> save(String name, Category category, Long authorId, int availableCopies);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> findById(Long id);
    Optional<Book> edit(Long id, BookDto bookDto);
    void markAsTaken(Long id);
}
