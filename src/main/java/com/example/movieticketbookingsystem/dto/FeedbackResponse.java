package com.example.movieticketbookingsystem.dto;

public record FeedbackResponse(
        String feedbackId,
        int rating,
        String review
) {
}
