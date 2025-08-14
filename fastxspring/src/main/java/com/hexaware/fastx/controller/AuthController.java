package com.hexaware.fastx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.AuthRequest;
import com.hexaware.fastx.dto.AuthResponse;
import com.hexaware.fastx.service.JwtService;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login/user")
    public AuthResponse userLogin(@RequestBody AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        if (auth.isAuthenticated()) {
            boolean isUser = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("User"));

            if (!isUser) {
                throw new RuntimeException("Not authorized as user");
            }

            return new AuthResponse(jwtService.generateToken(request.getEmail(),"User"));
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }

    @PostMapping("/login/admin")
    public AuthResponse adminLogin(@RequestBody AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        if (auth.isAuthenticated()) {
            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("Admin"));

            if (!isAdmin) {
                throw new RuntimeException("Not authorized as admin");
            }

            return new AuthResponse(jwtService.generateToken(request.getEmail(), "Admin"));
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }

    @PostMapping("/login/operator")
    public AuthResponse operatorLogin(@RequestBody AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        if (auth.isAuthenticated()) {
            boolean isOperator = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("Operator"));

            if (!isOperator) {
                throw new RuntimeException("Not authorized as bus operator");
            }

            return new AuthResponse(jwtService.generateToken(request.getEmail(), "Operator"));
        } else {
            throw new RuntimeException("Invalid login credentials");
        }
    }
}
