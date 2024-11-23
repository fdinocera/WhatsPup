package com.example.wpup_backend.Service;

import com.example.wpup_backend.Entities.User;
import com.example.wpup_backend.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username già in uso");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email già in uso");
        }

        // Cripta la password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("USER"); // Ruolo di default

        // Salva l'utente
        return userRepository.save(user);
    }
}

