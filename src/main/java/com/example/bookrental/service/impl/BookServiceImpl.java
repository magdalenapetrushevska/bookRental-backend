package com.example.bookrental.service.impl;

import com.example.bookrental.model.Author;
import com.example.bookrental.model.Book;
import com.example.bookrental.model.dto.BookDto;
import com.example.bookrental.model.enumerations.Category;
import com.example.bookrental.model.exceptions.BookNotFoundException;
import com.example.bookrental.model.exceptions.NotAvailableCopiesOfBookException;
import com.example.bookrental.repository.BookRepository;
import com.example.bookrental.service.AuthorService;
import com.example.bookrental.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, int availableCopies) {
        //TODO како да се земе category која што е enum тип
        Author author = this.authorService.findById(authorId);
        return Optional.of(this.bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorService.findById(bookDto.getAuthor());

        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, int availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorService.findById(authorId);

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        int numberOfAvaliableCopies = book.getAvailableCopies();
        if(numberOfAvaliableCopies==0){
            throw new NotAvailableCopiesOfBookException(id);
        }
        numberOfAvaliableCopies--;
        book.setAvailableCopies(numberOfAvaliableCopies);

        this.bookRepository.save(book);
    }


}
