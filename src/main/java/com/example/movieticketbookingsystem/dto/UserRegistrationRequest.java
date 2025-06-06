package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.UserRole;
import lombok.ToString;

import java.time.LocalDate;


public record UserRegistrationRequest (
        String username,
        String email,
        String password,
        String phoneNumber,
        UserRole userRole,
        LocalDate dateOfBirth
)
{}
