package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackTRepository extends JpaRepository<Feedback,String> {
}
