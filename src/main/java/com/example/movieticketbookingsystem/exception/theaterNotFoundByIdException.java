package com.example.movieticketbookingsystem.exception;

public class theaterNotFoundByIdException extends RuntimeException{
    private String message;
    public theaterNotFoundByIdException(String message){
        this.message=message;
    }
}
