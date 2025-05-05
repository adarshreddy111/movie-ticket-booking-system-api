package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import com.example.movieticketbookingsystem.mapper.ShowMapper;
import com.example.movieticketbookingsystem.repository.MovieRepository;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.ShowRepository;
import com.example.movieticketbookingsystem.repository.TheatreRepository;
import com.example.movieticketbookingsystem.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final MovieRepository movieRepository;
    private final ShowMapper showMapper;

    @Override
    public ShowResponse addShow(String theaterId, String screenId, String movieId, Long startTime) {
        return null;
    }


}




