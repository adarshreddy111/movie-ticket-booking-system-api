package com.example.movieticketbookingsystem.exception.handler;

import com.example.movieticketbookingsystem.exception.ShowTimeConflictException;
import com.example.movieticketbookingsystem.utility.ErrorStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ShowExceptionHandler {

    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleShowTimeConflictException(ShowTimeConflictException ex) {
        return responseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

}