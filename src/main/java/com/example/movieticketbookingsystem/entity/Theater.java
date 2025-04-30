package com.example.movieticketbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@ToString
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;
    private String name;
    private String address;
    private String city;
    private String landmark;

    @ManyToOne
    private TheaterOwner theaterOwner;

    @CreatedDate
    private Instant createdAt;
    @LastModifiedBy
    private Instant updatedAt;
    private String createdBy;

   @OneToMany(mappedBy = "theater")
    private List<Screen> screens;

   @OneToMany(mappedBy = "theater")
    private List<Show> shows;
}
