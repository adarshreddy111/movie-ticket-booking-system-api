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

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ScreenController {

    private final ScreenService screenService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("theaters/{theaterId}/screens")
    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    public ResponseEntity<ResponseStructure<ScreenResponse>> addScreen(@RequestBody @Valid ScreenRequest screenRequest, @PathVariable String theaterId){
        ScreenResponse screenResponse = screenService.addScreen(theaterId,screenRequest);
        return responseBuilder.sucess(HttpStatus.OK, "Screen has been successfully created", screenResponse);
    }

    @GetMapping("theaters/{theaterId}/screens/{screenId}")
    public ResponseEntity<ResponseStructure<ScreenResponse>> findScreen(@PathVariable String theaterId, @PathVariable String screenId){
        ScreenResponse screenResponse = screenService.findScreen(theaterId, screenId);
        return responseBuilder.sucess(HttpStatus.OK, "Screen has been successfully fetched", screenResponse);
    }
}
