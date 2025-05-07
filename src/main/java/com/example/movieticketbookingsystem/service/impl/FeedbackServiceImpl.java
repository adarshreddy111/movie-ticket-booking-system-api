package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.FeedbackRequest;
import com.example.movieticketbookingsystem.dto.FeedbackResponse;
import com.example.movieticketbookingsystem.entity.Feedback;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.exception.MovieNotFoundByIdException;
import com.example.movieticketbookingsystem.mapper.FeedbackMapper;
import com.example.movieticketbookingsystem.repository.FeedbackTRepository;
import com.example.movieticketbookingsystem.repository.MovieRepository;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final FeedbackTRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    @Override
    public FeedbackResponse createFeedback(String movieId, FeedbackRequest feedbackRequest, String email) {
        if(movieRepository.existsById(movieId)){
            Feedback feedback = copy(feedbackRequest, new Feedback(), movieId, email);

            return feedbackMapper.feedbackResponseMapper(feedback);
        }
        throw new MovieNotFoundByIdException("No movie found in database");
    }

    private Feedback copy(FeedbackRequest feedbackRequest, Feedback feedback, String movieId, String email) {
        feedback.setRating(feedbackRequest.rating());
        feedback.setReview(feedbackRequest.review());
        feedback.setMovie(movieRepository.findById(movieId).get());
        feedback.setUser((User) userRepository.findByEmail(email));
        feedbackRepository.save(feedback);
        return feedback;
    }
    }

