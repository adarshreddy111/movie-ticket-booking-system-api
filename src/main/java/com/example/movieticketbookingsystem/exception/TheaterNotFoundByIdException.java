package com.example.movieticketbookingsystem.exception;

public class TheaterNotFoundByIdException extends RuntimeException{
    private String message;

    public TheaterNotFoundByIdException(String message){
        this.message=message;
    }
}
