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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ScreenRequest(
        @NotNull(message = "Screen type is required")
        ScreenType screenType,

        @NotNull(message = "Capacity is required")
        @Min(value = 1, message = "Capacity must be at least 1")
        Integer capacity,

        @NotNull(message = "Number of rows is required")
        @Min(value = 1, message = "Number of rows must be at least 1")
        Integer noOfRows
) {}
