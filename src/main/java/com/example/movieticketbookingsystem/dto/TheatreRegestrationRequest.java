package com.example.movieticketbookingsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TheatreRegestrationRequest(
      @NotNull(message = "TheatreName is required")
      @Size(min=1,max = 20,message = "Name cannot be blank")
     String name,

      @NotNull(message = "Address is required")
      @Size(min = 1,max = 50,message = "Address cannot be blank")
      String address,

      @NotNull(message = "City is required")
      @Size(min = 1,max = 20,message = "City cannot be blank")
      String city,

      @NotNull(message = "LandMark is required")
      @Size(min = 1,max = 30,message = "LandMark cannot be blank")
      String landmark


) { }
