package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.service.ScreenService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
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
        private final RestResponseBuilder responseBuilder;

        @PostMapping("theaters/{theaterId}/screens")
        public ResponseEntity<ResponseStructure<ScreenResponse>> addScreen(@RequestBody ScreenRequest screenRequest, @PathVariable String theaterId){
            ScreenResponse screenResponse = screenService.addScreen(screenRequest, theaterId);
            return responseBuilder.sucess(HttpStatus.OK, "Screen has been successfully created", screenResponse);
        }


    }
