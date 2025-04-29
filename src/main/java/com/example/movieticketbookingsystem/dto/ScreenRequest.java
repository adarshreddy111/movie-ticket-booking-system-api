package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.ScreenType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ScreenRequest(

        String screenId,

        @NotNull(message = "Screen type is required")
        ScreenType screenType,

        @NotNull(message = "capacity is required")
        @Size(min = 1,message = "Capacity cannot be blank")
        Integer capacity,

        @NotNull(message = "noOfRows is required")
        @Size(min = 1,message = "noOfRows cannot be blank")
        Integer noOfRows

        ) {
}
