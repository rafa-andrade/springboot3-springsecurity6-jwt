package com.example.security.controller;

import com.example.security.controller.dto.LoginDto;
import com.example.security.entities.Role;
import com.example.security.service.AuthenticationService;
import com.example.security.controller.dto.UserDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody @Valid UserDto user) {
        return authenticationService.register(user, Role.USER);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody @Valid LoginDto request) {
        return authenticationService.login(request);
    }
}
