package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.TheatreRegestrationRequest;
import com.example.movieticketbookingsystem.dto.TheatreResponse;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.UserRole;
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
    public TheatreResponse addTheatre(String email, TheatreRegestrationRequest theatreRegestrationRequest) {
        if (userRepository.existsByEmail(email) &&  userRepository.findByEmail(email).getUserRole()== UserRole.THEATER_OWNER){
            UserDetails user=userRepository.findByEmail(email);
            Theater theater=copy(theatreRegestrationRequest,new Theater(),user);
            return theatreMapper.theatreResponseMapper(theater);
        }
        throw new UserNotFoundByEmailException("No theater owner with the provided email");
    }


    public Theater copy(TheatreRegestrationRequest regestrationRequest,Theater theater,UserDetails userDetails){
        theater.setAddress(regestrationRequest.address());
        theater.setCity(regestrationRequest.city());
        theater.setLandmark(regestrationRequest.landmark());
        theater.setName(regestrationRequest.name());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theatreRepository.save(theater);
        return theater;
    }
}
