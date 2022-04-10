package com.example.bookrental.repository;

import com.example.bookrental.model.Book;
import com.example.bookrental.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
