package com.example.security.service;

import com.example.security.entities.Role;
import com.example.security.entities.User;
import com.example.security.controller.dto.LoginDto;
import com.example.security.controller.dto.UserDto;
import com.example.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(UserDto userDto, Role role) {
        var user = User.builder()
            .name(userDto.getName())
            .email(userDto.getEmail())
            .password(passwordEncoder.encode(userDto.getPassword()))
            .role(role)
            .build();

        userRepository.save(user);
        return jwtService.generateToken(user);
    }

    public String login(LoginDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        return jwtService.generateToken(user);
    }
}
