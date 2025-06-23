package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Custom.JwtService;
import com.example.swiggyclone4.Dto.AuthResponse;
import com.example.swiggyclone4.Dto.SigninRequest;
import com.example.swiggyclone4.Entity.User;
import com.example.swiggyclone4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SigninService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public AuthResponse signin(SigninRequest signinRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));


        String token = jwtService.generateToken(Map.of("role",user.getRole().name()),user);
        return new AuthResponse(token);

    }
}
