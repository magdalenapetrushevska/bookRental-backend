package com.example.bookrental.repository;

import com.example.bookrental.model.Author;
import com.example.bookrental.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
