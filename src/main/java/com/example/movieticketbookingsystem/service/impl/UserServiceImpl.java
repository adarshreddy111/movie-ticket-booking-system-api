package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.UserRole;
import com.example.movieticketbookingsystem.exception.UserExistByEmailException;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails addUser(UserDetails user) {
        if(! userRepository.existsByEmail(user.getEmail())){
//            return copy(user);
            switch (user.getUserRole()){
                case USER -> copy(new User(), user);
                case THEATER_OWNER -> copy(new TheaterOwner(), user);
            }
        }
        throw new UserExistByEmailException("User with the Email is already exists");
    }

    private UserDetails copy(UserDetails userRole, UserDetails user){
//        UserDetails userRole = user.getUserRole()==UserRole.USER ? new User() : new TheaterOwner();
        userRole.setUserRole(user.getUserRole());
        userRole.setEmail(user.getEmail());
        userRole.setPassword(user.getPassword());
        userRole.setCreatedAt(user.getCreatedAt());
        userRole.setDateOfBirth(user.getDateOfBirth());
        userRole.setPhoneNumber(user.getPhoneNumber());
        userRole.setUsername(user.getUsername());
        userRole.setUpdatedAt(user.getUpdatedAt());
        userRepository.save(userRole);
        return userRole;
    }
}