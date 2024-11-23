package com.example.wpup_backend.Controller;

import com.example.wpup_backend.Entities.User;
import com.example.wpup_backend.Exception.EmailAlreadyExistsException;
import com.example.wpup_backend.Service.AuthService;
import com.example.wpup_backend.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthControllerReg {

    @Autowired
    private final AuthService authService;

    @Autowired
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

    // Gestione dell'eccezione EmailAlreadyExistsException
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
