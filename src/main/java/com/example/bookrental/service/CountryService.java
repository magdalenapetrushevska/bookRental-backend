package com.example.bookrental.service;

import com.example.bookrental.model.Country;

public interface CountryService {
    Country save(Long id, String name, String continent);
    Country findById(Long id);
}
