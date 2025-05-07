package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.FeedbackResponse;
import com.example.movieticketbookingsystem.entity.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackResponse feedbackResponseMapper(Feedback feedback){
        if(feedback==null)
         return null;
        return new FeedbackResponse(
                feedback.getFeedbackId(),
                feedback.getRating(),
                feedback.getReview()

        );
    }
}
