package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.FeedbackRequest;
import com.example.movieticketbookingsystem.dto.FeedbackResponse;
import jakarta.validation.Valid;

public interface FeedbackService {
    FeedbackResponse createFeedback(String movieId, @Valid FeedbackRequest feedbackRequest, String email);
}
