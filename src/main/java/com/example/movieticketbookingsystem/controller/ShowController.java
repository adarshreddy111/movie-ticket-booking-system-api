package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import com.example.movieticketbookingsystem.repository.ShowRepository;
import com.example.movieticketbookingsystem.service.ShowService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class ShowController {

    private final ShowService showService;
    private final RestResponseBuilder restResponseBuilder;


    public ResponseEntity<ResponseStructure<ShowResponse>> addShow(@PathVariable String theaterId, @PathVariable String screenId, @Valid @RequestBody ShowResponse showResponse){
       ShowResponse showResponse1=showService.addShow(theaterId,screenId,showResponse);
       return restResponseBuilder.sucess(HttpStatus.OK,"Show added successfully",showResponse1);
    }

}
