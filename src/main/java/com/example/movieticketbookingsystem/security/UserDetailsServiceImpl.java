package com.example.movieticketbookingsystem.security;

import com.example.movieticketbookingsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     com.example.movieticketbookingsystem.entity.UserDetails user = userRepository.findByEmail(username);

          if(user== null){
              throw new UsernameNotFoundException("user not found by this username");
          }
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getUserRole().name())
                .build();

    }
}
