package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.ShowResponse;

public interface ShowService {

    ShowResponse addShow(String theaterId, String screenId, ShowResponse showResponse);
}
