package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.MovieResponse;

public interface MovieService {
    MovieResponse getMovie(String movieId);
}