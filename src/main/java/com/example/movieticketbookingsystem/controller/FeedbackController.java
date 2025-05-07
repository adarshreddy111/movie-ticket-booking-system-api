package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.FeedbackRequest;
import com.example.movieticketbookingsystem.dto.FeedbackResponse;
import com.example.movieticketbookingsystem.service.FeedbackService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FeedbackController {

    private RestResponseBuilder restResponseBuilder;
    private FeedbackService feedbackService;

    @PostMapping("/movies/{movieId}/feedbacks")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ResponseStructure<FeedbackResponse>> createFeedback(@PathVariable String movieId, @RequestBody @Valid FeedbackRequest feedbackRequest){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        FeedbackResponse feedbackResponse = feedbackService.createFeedback(movieId,feedbackRequest,email);
        return restResponseBuilder.sucess(HttpStatus.OK,"Feedback successfully created",feedbackResponse);
    }

}
