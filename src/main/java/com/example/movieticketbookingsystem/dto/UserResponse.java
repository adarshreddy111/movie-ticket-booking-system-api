package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.UserRole;
import lombok.Builder;

@Builder
public record UserResponse(
        String userId,
        String username,
        String email,
        String phoneNumber,
        UserRole userRole

) {

}
