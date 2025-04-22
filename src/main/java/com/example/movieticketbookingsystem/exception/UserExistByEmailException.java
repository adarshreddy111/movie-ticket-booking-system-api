package com.example.movieticketbookingsystem.exception;


import lombok.Getter;

@Getter
public class UserExistByEmailException extends RuntimeException {

    private String message;

    public UserExistByEmailException(String message) {
        this.message = message;
    }
}
