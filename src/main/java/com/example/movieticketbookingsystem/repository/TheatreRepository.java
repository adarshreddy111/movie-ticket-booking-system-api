package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theater,String> {
}
