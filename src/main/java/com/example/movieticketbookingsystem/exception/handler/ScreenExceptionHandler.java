package com.example.movieticketbookingsystem.exception.handler;

import com.example.movieticketbookingsystem.exception.NoOfRowsExceedCapacityException;
import com.example.movieticketbookingsystem.exception.ScreenNotFoundByIdException;
import com.example.movieticketbookingsystem.utility.ErrorStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@AllArgsConstructor
public class ScreenExceptionHandler {

    private final RestResponseBuilder restResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleNoOfRowsExceedCapacityException(NoOfRowsExceedCapacityException ex) {
        return restResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleScreenNotFoundByIdException(ScreenNotFoundByIdException ex) {
        return restResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
