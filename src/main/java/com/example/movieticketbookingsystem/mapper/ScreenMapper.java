package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.entity.Screen;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {


    public ScreenResponse screenResponseMapper(Screen screen){
        return null;

    public ScreenResponse screenResponseMapper(Screen screen) {
        if (screen == null) {
            return null;
        }

        return ScreenResponse.builder()
                .screenId(screen.getScreenId())
                .screenType(screen.getScreenType())
                .capacity(screen.getCapacity())
                .noOfRows(screen.getNoOfRows())
                .build();

    }
}
