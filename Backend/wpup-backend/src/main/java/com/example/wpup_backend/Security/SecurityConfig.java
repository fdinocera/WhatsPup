package com.example.wpup_backend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/oauth2/authorization/google")
//                        .defaultSuccessUrl("/dashboard", true)
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                        .permitAll()
//                );
//        return http.build();


        http
                .csrf().disable() // Disabilita CSRF (opzionale, per test API)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/register/**").permitAll() // Consenti l'accesso senza autenticazione

                        .requestMatchers("/api/chat/**").permitAll() // Consenti l'accesso senza autenticazione
                        .requestMatchers("/api/chat/history/**").permitAll() // Consenti l'accesso senza autenticazione

                        .anyRequest().authenticated() // Richiedi autenticazione per tutto il resto
                )
                .oauth2Login(); // Configura OAuth2 per il resto delle API


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


