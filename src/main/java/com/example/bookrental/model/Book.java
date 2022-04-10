package com.example.bookrental.model;

import com.example.bookrental.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToOne
    private Author author;

    private int availableCopies;

    public Book(){

    }

    public Book(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
