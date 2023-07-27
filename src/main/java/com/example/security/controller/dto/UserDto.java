package com.example.security.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
  @NotEmpty
  private String name;

  @NotEmpty
  @Email
  private String email;

  @NotEmpty
  private String password;
}
