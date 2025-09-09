package com.example.basicecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public class RegistroDTO {
    @NotBlank
    public String username;
    @NotBlank public String password;
}
