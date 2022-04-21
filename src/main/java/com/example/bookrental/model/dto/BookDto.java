package com.example.bookrental.model.dto;

import com.example.bookrental.model.Author;
import com.example.bookrental.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
public class BookDto {

    private String name;
    private Category category;
    private Long author;
    private int availableCopies;

    public BookDto(){}

    public BookDto(String name, Category category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
