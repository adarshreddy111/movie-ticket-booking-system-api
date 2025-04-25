package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.TheatreResponse;
import com.example.movieticketbookingsystem.entity.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheatreMapper {
    public TheatreResponse theatreResponseMapper(Theater theater){
        if (theater==null)
            return null;
        return new TheatreResponse(
                theater.getTheaterId(),
                theater.getName(),
                theater.getAddress(),
                theater.getCity(),
                theater.getLandmark()

        );

    }
}
