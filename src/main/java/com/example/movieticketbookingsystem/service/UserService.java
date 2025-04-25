package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserResponse;
import com.example.movieticketbookingsystem.dto.UserUpdationRequest;

public interface UserService {
    UserResponse addUser(UserRegistrationRequest user);

    UserResponse editUser(UserUpdationRequest user, String email);

    UserResponse softDelete(String email);
}