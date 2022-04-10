package com.example.bookrental.config;

import com.example.bookrental.model.Book;
import com.example.bookrental.model.enumerations.Category;
import com.example.bookrental.service.AuthorService;
import com.example.bookrental.service.BookService;
import com.example.bookrental.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData(){

        this.countryService.save(1L,"Germany","Europe");
        this.countryService.save(2L,"USA","North America");
        this.countryService.save(3L,"Italy","Europe");
        this.countryService.save(4L,"China","Asia");
        this.countryService.save(5L,"Serbia","Europe");


        this.authorService.save(1L,"Patrick","Rothfuss",this.countryService.findById(2L));
        this.authorService.save(2L,"Yan","Lianke",this.countryService.findById(4L));
        this.authorService.save(3L,"Erik","Larson",this.countryService.findById(2L));
        this.authorService.save(4L,"Franz","Kafka",this.countryService.findById(1L));
        this.authorService.save(5L,"Luigi","Pirandello",this.countryService.findById(3L));
        this.authorService.save(6L,"Ruth","Ware",this.countryService.findById(2L));
        this.authorService.save(7L,"Tennessee","Williams",this.countryService.findById(2L));


        this.bookService.save("The Name of the Wind", Category.FANTASY,1L,10);
        this.bookService.save("The Four Books", Category.NOVEL,2L,6);
        this.bookService.save("The Devil in the White City", Category.HISTORY,3L,2);
        this.bookService.save("The Metamorphosis", Category.CLASSICS,4L,15);
        this.bookService.save("Six Characters in Search of an Author", Category.DRAMA,5L,2);
        this.bookService.save("The Woman in Cabin 10", Category.THRILER,6L,3);
        this.bookService.save("A Streetcar Named Desire", Category.DRAMA,7L,3);
    }
}
