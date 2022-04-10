package com.example.bookrental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @OneToOne
    private Country country;

    public Author(){

    }

    public Author(Long id, String name, String surname, Country country) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
