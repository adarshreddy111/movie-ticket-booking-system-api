package com.example.movieticketbookingsystem.repository;
import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails,Long> {

    boolean existsByEmail(String email);
}
