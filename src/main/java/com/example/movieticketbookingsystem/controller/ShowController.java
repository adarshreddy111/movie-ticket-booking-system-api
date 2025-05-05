package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import com.example.movieticketbookingsystem.repository.ShowRepository;
import com.example.movieticketbookingsystem.service.ShowService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@Validated
public class ShowController {

    private final ShowService showService;
    private final RestResponseBuilder restResponseBuilder;


    @PostMapping("theaters/{theaterId}/screens/{screenId}/shows")
    @PreAuthorize("hasAuthority('THEATER_OWNER')")
    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(@PathVariable String theaterId, @PathVariable String screenId,String movieId, @NotNull Long startTime){
       ShowResponse showResponse=showService.addShow(theaterId,screenId,movieId,startTime);
       return restResponseBuilder.sucess(HttpStatus.OK,"Show added successfully",showResponse);
    }

}
