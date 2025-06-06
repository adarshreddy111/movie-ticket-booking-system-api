package com.example.movieticketbookingsystem.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.net.http.HttpResponse;
@Builder
@Getter
public class FieldErrorStructure <T>{
    private int statusCode;
    @JsonProperty(namespace = "error_message")
    private  String errorMessage;
    T data;
}
