package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.TheatreRepository;
import com.example.movieticketbookingsystem.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Override
    public ScreenResponse addScreen(String theaterId, ScreenRequest screenRequest) {
        return null;
    }
}
