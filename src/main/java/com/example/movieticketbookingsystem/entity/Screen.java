package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;


@Setter
@Getter
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenId;
    @Enumerated(value = EnumType.STRING)
    private ScreenType screenType;
    private Integer capacity;
    private Integer noOfRows;

    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    private String createdBy;
    private  String theaterId;

    @ManyToOne
    private  Theater theater;

    @OneToMany(mappedBy = "screen")

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenId;

    @Enumerated(value = EnumType.STRING)
    private ScreenType screenType;

    private Integer capacity;

    private Integer noOfRows;

    private String createdBy;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST)

    private List<Seat> seats;
}
