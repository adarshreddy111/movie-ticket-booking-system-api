package com.example.movieticketbookingsystem.utility;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorStructure{

    private int statusCode;
    @JsonProperty(namespace = "error_message")
    private String errorMessage;
}