package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.TheatreRegestrationRequest;
import com.example.movieticketbookingsystem.dto.TheatreRequest;
import com.example.movieticketbookingsystem.dto.TheatreResponse;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.service.TheatreService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TheatreController {
    private final TheatreService theatreService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/theaters")
    public ResponseEntity<ResponseStructure<TheatreResponse>> addTheatre(String email , @Valid @RequestBody TheatreRequest theatreRequest){
        TheatreResponse theatreResponse=theatreService.addTheatre(email,theatreRequest);
        return restResponseBuilder.sucess(HttpStatus.OK,"Theater has been added successfully",theatreResponse);

    }
@GetMapping("theaters/{theaterId}")
    public ResponseEntity<ResponseStructure<TheatreResponse>> findTheater(@PathVariable String theaterId){
        TheatreResponse theatreResponse=theatreService.findTheater(theaterId);
        return  restResponseBuilder.sucess(HttpStatus.OK,"Theater has been successfully fetched",theatreResponse);
}

@PutMapping("theaters/{theaterId}")
    public  ResponseEntity<ResponseStructure<TheatreResponse>> updateTheater(@PathVariable String theaterId,@Valid @RequestBody TheatreRequest theatreRequest){
        TheatreResponse theatreResponse=theatreService.updateTheater(theaterId,theatreRequest);
        return restResponseBuilder.sucess(HttpStatus.OK,"Theater has been updated successfully",theatreResponse);
}

}
