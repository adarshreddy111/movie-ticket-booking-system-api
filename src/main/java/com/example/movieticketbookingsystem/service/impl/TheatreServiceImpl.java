package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.TheatreRequest;
import com.example.movieticketbookingsystem.dto.TheatreRequest;
import com.example.movieticketbookingsystem.dto.TheatreResponse;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.UserRole;
import com.example.movieticketbookingsystem.exception.TheaterNotFoundByIdException;
import com.example.movieticketbookingsystem.exception.UserNotFoundByEmailException;
import com.example.movieticketbookingsystem.mapper.TheatreMapper;
import com.example.movieticketbookingsystem.repository.TheatreRepository;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.TheatreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final TheatreMapper theatreMapper;
    private final UserRepository userRepository;

    @Override
    public TheatreResponse addTheatre(String email, TheatreRequest theatreRequest) {
        if (userRepository.existsByEmail(email) &&  userRepository.findByEmail(email).getUserRole()== UserRole.THEATER_OWNER){
            UserDetails user=userRepository.findByEmail(email);
            Theater theater=copy(theatreRequest,new Theater(),user);
            return theatreMapper.theatreResponseMapper(theater);
        }
        throw new UserNotFoundByEmailException("No theater owner with the provided email");
    }

    @Override
    public TheatreResponse findTheater(String theaterId) {
        if(theatreRepository.existsById(theaterId)){
            Theater theater=theatreRepository.findById(theaterId).get();
            return theatreMapper.theatreResponseMapper(theater);
        }
        throw new TheaterNotFoundByIdException("Theater has not been found by the Id");
    }

    @Override
    public TheatreResponse updateTheater(String theaterId,TheatreRequest theatreRequest) {
        if(theatreRepository.existsById(theaterId)){
            Theater theater=theatreRepository.findById(theaterId).get();
            return theatreMapper.theatreResponseMapper(theater);

        }
       throw new TheaterNotFoundByIdException("Theater not found by Id");
    }


    public Theater copy(TheatreRequest theatreRequest, Theater theater, UserDetails userDetails){
        theater.setAddress(theatreRequest.address());
        theater.setCity(theatreRequest.city());
        theater.setLandmark(theatreRequest.landmark());
        theater.setName(theatreRequest.name());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theatreRepository.save(theater);
        return theater;
    }
}
