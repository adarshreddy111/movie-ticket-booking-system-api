package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.Certificate;
import com.example.movieticketbookingsystem.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Entity
@Setter
@Getter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;
    private String title;
    private String description;
    private String cast;
    private Duration runtime;

    @Enumerated(value = EnumType.STRING)
    private Certificate certificate;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;


}
