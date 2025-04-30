package com.example.movieticketbookingsystem.exception;

public class ScreenNotFoundByIdException  extends RuntimeException{

    private String message;

    public ScreenNotFoundByIdException(String message){
        this.message=message;
    }
}
