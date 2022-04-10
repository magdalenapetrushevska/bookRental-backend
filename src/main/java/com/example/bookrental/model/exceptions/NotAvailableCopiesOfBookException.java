package com.example.bookrental.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotAvailableCopiesOfBookException extends RuntimeException{
    public NotAvailableCopiesOfBookException(Long id) {
        super(String.format("There is no more available copies of book with id:", id));
    }
}
