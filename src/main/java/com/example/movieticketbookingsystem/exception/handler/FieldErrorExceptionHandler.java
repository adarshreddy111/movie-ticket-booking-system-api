package com.example.movieticketbookingsystem.exception.handler;

import com.example.movieticketbookingsystem.utility.FieldErrorStructure;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ObjectError> errors = ex.getAllErrors();

        List<CustomFieldError> customFieldErrors = new ArrayList<>();

        for(ObjectError error : errors){
            if (error instanceof FieldError){
                FieldError fieldError = (FieldError) error;
                customFieldErrors.add(CustomFieldError.builder()
                        .field(fieldError.getField())
                        .rejectedValue((String) fieldError.getRejectedValue())
                        .errorMessage(fieldError.getDefaultMessage())
                        .build());
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FieldErrorStructure.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .data(customFieldErrors)
                .errorMessage("Invalid Input")
                .build());
    }


    @Getter
    @Builder
    public static class CustomFieldError {
        String field;
        String rejectedValue;
        String errorMessage;
    }
}
