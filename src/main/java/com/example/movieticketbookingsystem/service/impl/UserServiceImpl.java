package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.exception.UserExistByEmailException;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.movieticketbookingsystem.enums.UserRole.THEATER_OWNER;
import static com.example.movieticketbookingsystem.enums.UserRole.USER;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails addUser(UserRegistrationRequest user) {
        System.out.println(user);
        if (userRepository.existsByEmail(user.email())) {
//            return copy(user);
            throw new UserExistByEmailException("User with the Email is already exists");

        }
        UserDetails userDetails = switch (user.userRole()) {
            case USER -> copy(new User(), user);
            case THEATER_OWNER -> copy(new TheaterOwner(), user);
        };
        System.out.println(user);
        return userDetails;


    }

    private UserDetails copy(UserDetails userRole, UserRegistrationRequest user) {
//        UserDetails userRole = user.getUserRole()==UserRole.USER ? new User() : new TheaterOwner();
        userRole.setUserRole(user.userRole());
        userRole.setEmail(user.email());
        userRole.setPassword(user.password());
        userRole.setDateOfBirth(user.dateOfBirth());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setUsername(user.username());
        userRepository.save(userRole);
        return userRole;
    }
}