package com.example.movieticketbookingsystem.exception;
import lombok.Getter;

@Getter
public class UserNotFoundByEmailException extends RuntimeException {
        private String message;

        public UserNotFoundByEmailException(String message) {
            this.message = message;
        }
    }

