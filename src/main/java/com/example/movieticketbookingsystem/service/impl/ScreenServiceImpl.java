package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;

import com.example.movieticketbookingsystem.repository.ScreenRepository;

import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Seat;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.exception.ScreenNotFoundByIdException;
import com.example.movieticketbookingsystem.exception.TheaterNotFoundByIdException;
import com.example.movieticketbookingsystem.mapper.ScreenMapper;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.SeatRepository;

import com.example.movieticketbookingsystem.repository.TheatreRepository;
import com.example.movieticketbookingsystem.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.LinkedList;
import java.util.List;


@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {


    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Override
    public ScreenResponse addScreen(String theaterId, ScreenRequest screenRequest) {
        return null;

    private final TheatreRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final SeatRepository seatRepository;
    private final ScreenMapper screenMapper;

    @Override
    public ScreenResponse addScreen(String theaterId, ScreenRequest screenRequest) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new TheaterNotFoundByIdException("No Theater found by ID"));

        Screen screen = mapToScreen(screenRequest, theater);
        screenRepository.save(screen);

        List<Seat> seats = generateSeats(screen, screenRequest.capacity());
        seatRepository.saveAll(seats);
        screen.setSeats(seats);

        return screenMapper.screenResponseMapper(screen);
    }

    @Override
    public ScreenResponse findScreen(String theaterId, String screenId) {

        if (theaterRepository.existsById(theaterId)) {
            if (screenRepository.existsById(screenId)) {
                return screenMapper.screenResponseMapper(screenRepository.findById(screenId).get());
            }
            throw new ScreenNotFoundByIdException("Screen Not Found by Id");
        }
        throw new TheaterNotFoundByIdException("Theater not found by Id");

    }

    private Screen mapToScreen(ScreenRequest request, Theater theater) {
        Screen screen = new Screen();
        screen.setScreenType(request.screenType());
        screen.setCapacity(request.capacity());
        screen.setNoOfRows(request.noOfRows());
        screen.setTheater(theater);
        return screen;
    }

    private List<Seat> generateSeats(Screen screen, Integer capacity) {
        List<Seat> seats = new LinkedList<>();
        for (int i = 1; i <= capacity; i++) {
            Seat seat = new Seat();
            seat.setScreen(screen);
            seats.add(seat);
        }
        return seats;

    }
}
