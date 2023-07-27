package com.example.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource")
@AllArgsConstructor
public class AuthorizationController {

    @GetMapping("/user")
    @ResponseBody
    @PreAuthorize("hasAuthority('USER')")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('ADMIN')")
    public String helloAdmin() {
        return "Hello Admin";
    }
}
