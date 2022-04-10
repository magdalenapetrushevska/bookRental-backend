package com.example.bookrental.service.impl;

import com.example.bookrental.model.Country;
import com.example.bookrental.model.exceptions.CountryNotFoundException;
import com.example.bookrental.repository.CountryRepository;
import com.example.bookrental.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Long id, String name, String continent) {
        return this.countryRepository.save(new Country(id,name, continent));
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }
}
