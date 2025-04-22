package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.entity.UserDetails;

public interface UserService {
    public UserDetails addUser(UserDetails user);
}