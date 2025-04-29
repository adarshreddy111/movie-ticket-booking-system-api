package com.example.movieticketbookingsystem.dto;

import lombok.Builder;

@Builder
public record ScreenResponse(

        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows


) { }
