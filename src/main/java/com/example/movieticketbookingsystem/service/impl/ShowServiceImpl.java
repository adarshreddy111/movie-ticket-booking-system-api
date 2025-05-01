package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import com.example.movieticketbookingsystem.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {
    @Override
    public ShowResponse addShow(String theaterId, String screenId, ShowResponse showResponse) {
    return null;
    }
}
