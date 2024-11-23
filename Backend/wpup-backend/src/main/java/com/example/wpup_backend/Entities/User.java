package com.example.wpup_backend.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password; // Sarà criptata

    @Email
    @NotBlank
    private String email;

    private String roles; // Ruoli utente, es. "USER,ADMIN"
}

