package com.example.bookrental.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Country {

    @Id
    private Long id;

    private String name;

    private String continent;


    public Country(){

    }

    public Country(Long id, String name, String continent) {
        this.id=id;
        this.name = name;
        this.continent = continent;
    }
}
