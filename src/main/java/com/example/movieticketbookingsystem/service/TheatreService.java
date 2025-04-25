package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.TheatreRegestrationRequest;
import com.example.movieticketbookingsystem.dto.TheatreRequest;
import com.example.movieticketbookingsystem.dto.TheatreResponse;
import jakarta.validation.Valid;

public interface TheatreService {
    TheatreResponse addTheatre(String email, @Valid TheatreRequest theatreRequest);


    TheatreResponse findTheater(String theaterId);

    TheatreResponse updateTheater(String theaterId, TheatreRequest theatreRequest);
}
