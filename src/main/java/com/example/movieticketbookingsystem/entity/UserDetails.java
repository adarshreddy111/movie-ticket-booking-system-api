package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Setter
@Getter
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
    private LocalDate dateOfBirth;
    private  boolean isDelete=false;
    private Instant deletedAt;


    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
}