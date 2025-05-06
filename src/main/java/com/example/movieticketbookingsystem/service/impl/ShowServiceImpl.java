package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import com.example.movieticketbookingsystem.entity.Movie;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Show;
import com.example.movieticketbookingsystem.exception.MovieNotFoundByIdException;
import com.example.movieticketbookingsystem.exception.ScreenNotFoundByIdException;
import com.example.movieticketbookingsystem.exception.ShowTimeConflictException;
import com.example.movieticketbookingsystem.exception.TheaterNotFoundByIdException;
import com.example.movieticketbookingsystem.mapper.ShowMapper;
import com.example.movieticketbookingsystem.repository.MovieRepository;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.ShowRepository;
import com.example.movieticketbookingsystem.repository.TheatreRepository;
import com.example.movieticketbookingsystem.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final MovieRepository movieRepository;
    private final ShowMapper showMapper;


    @Override
    public ShowResponse addShow(String theaterId, String screenId, String movieId, Long startTime) {

        if (theatreRepository.existsById(theaterId)) {

            if (screenRepository.existsById(screenId)) {

                if (movieRepository.existsById(movieId)) {

                    Screen screen = screenRepository.findById(screenId).get();
                    Set<Show> shows =  screen.getShows();


                    Movie movie = movieRepository.findById(movieId).get();

                    Instant instantStartTime = Instant.ofEpochMilli(startTime);


                    for (Show s : shows) {
                        Instant showStartTime = s.getStartsAt();
                        Instant showEndTime = s.getEndsAt();
                        Instant movieCompletionTime = instantStartTime.plus(movie.getRuntime());

                        if (! ( movieCompletionTime.isBefore(showStartTime) || instantStartTime.isAfter(showEndTime) )) {
                            throw new ShowTimeConflictException("Another Show is been Booked");
                        }
                    }

                    Show show = copy(new Show(), startTime, screen, movie);


                    return showMapper.showResponseMapper(show);

                }

                throw new MovieNotFoundByIdException("Movie Id not found in the database");
            }
            throw new ScreenNotFoundByIdException("Screen Id not found in the database");

        }
        throw new TheaterNotFoundByIdException("Theater Id not found in the database");
    }

    private Show copy(Show show, Long startTime, Screen screen, Movie movie) {
        show.setScreen(screen);
        show.setMovie(movie);
        Instant instantStartTime = Instant.ofEpochMilli(startTime);
        show.setStartsAt(instantStartTime);
        Instant endTime = instantStartTime.plus(movie.getRuntime());
        System.out.println(endTime);
        show.setEndsAt(endTime);
        showRepository.save(show);
        return show;
    }
}