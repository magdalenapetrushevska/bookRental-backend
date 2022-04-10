package com.example.bookrental.web;

import com.example.bookrental.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://https://app-book-rental.herokuapp.com")
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @GetMapping
    private List<Category> findAllCategories() {
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}
