package com.example.movieticketbookingsystem.exception;

import lombok.Getter;

@Getter
public class MovieNotFoundByIdException extends RuntimeException {

    private String message;

    public MovieNotFoundByIdException(String message) {
        this.message = message;
    }
}
