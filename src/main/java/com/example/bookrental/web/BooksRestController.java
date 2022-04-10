package com.example.bookrental.web;

import com.example.bookrental.model.Author;
import com.example.bookrental.model.Book;
import com.example.bookrental.model.dto.BookDto;
import com.example.bookrental.model.enumerations.Category;
import com.example.bookrental.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BooksRestController {

    private final BookService bookService;

    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam String name,@RequestParam Category category,@RequestParam Long author,@RequestParam int availableCopies) {
        return this.bookService.save(name, category, author, availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


//    @PostMapping("/add")
//    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
//        return this.bookService.save(bookDto)
//                .map(product -> ResponseEntity.ok().body(product))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id)==null) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestParam String name,@RequestParam Category category,@RequestParam Long authorId,@RequestParam int availableCopies) {
        return this.bookService.edit(id,name,category,authorId,availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PutMapping("/taken/{id}")
    public ResponseEntity taken(@PathVariable Long id) {
        this.bookService.markAsTaken(id);
        return ResponseEntity.ok().build();
    }


}


