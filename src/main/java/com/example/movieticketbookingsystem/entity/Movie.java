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
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ElementCollection
    private Set<String> castList;

    @Column(name = "runtime")
    private Duration runtime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "certificate")
    private Certificate certificate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Show> shows = new HashSet<>();
}