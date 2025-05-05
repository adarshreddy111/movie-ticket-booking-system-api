package com.example.movieticketbookingsystem.dto;

import lombok.Builder;

@Builder
public record SeatRespose (
        String seatId,
        String name
)
{}