package com.example.wpup_backend.Controller;

import com.example.wpup_backend.Entities.User;
import com.example.wpup_backend.Service.AuthService;
import com.example.wpup_backend.Utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthControllerReg {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthControllerReg(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
        User registeredUser = authService.register(user);
        String token = jwtUtil.generateToken(registeredUser.getUsername());

        return ResponseEntity.ok(token);
    }
}
