package com.example.security;

import com.example.security.controller.dto.UserDto;
import com.example.security.entities.Role;
import com.example.security.service.AuthenticationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SecurityApplication.class, args);

		context.getBean(AuthenticationService.class)
				.register(new UserDto("admin", "admin@admin.com", "12345"), Role.ADMIN);
	}

}
