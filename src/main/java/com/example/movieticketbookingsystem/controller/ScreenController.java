package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.service.ScreenService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ScreenController {

    private final ScreenService screenService;
    private final RestResponseBuilder restResponseBuilder;
    @PostMapping("/screens")
    public ResponseEntity<ResponseStructure<ScreenResponse>> addScreen(@PathVariable String theaterId, @Valid @RequestBody ScreenRequest screenRequest){
        ScreenResponse screenResponse=screenService.addScreen(theaterId,screenRequest);
        return restResponseBuilder.sucess(HttpStatus.OK,"Screen has been added successfully",screenResponse);

    }
}
