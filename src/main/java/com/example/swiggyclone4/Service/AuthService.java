package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Custom.JwtService;
import com.example.swiggyclone4.Dto.AuthResponse;
import com.example.swiggyclone4.Dto.SignupRequest;
import com.example.swiggyclone4.Entity.Role;
import com.example.swiggyclone4.Entity.User;
import com.example.swiggyclone4.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse authenticate(SignupRequest signupRequest) {
        if(userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        User user=User.builder()
                .name(signupRequest.getName())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userRepository.save(user);

        String token= jwtService.generateToken(Map.of("role",user.getRole().name()),user);
        return new AuthResponse(token);

    }

}
