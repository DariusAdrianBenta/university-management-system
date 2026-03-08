package com.university.ums.service;

import com.university.ums.dto.LoginRequest;
import com.university.ums.dto.LoginResponse;
import com.university.ums.dto.RegisterRequest;
import com.university.ums.entity.Role;
import com.university.ums.entity.User;
import com.university.ums.repository.UserRepository;
import com.university.ums.security.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public void register(RegisterRequest register){
        User user = User.builder()
                .firstName(register.getFirstName())
                .lastName(register.getLastName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(Role.ROLE_STUDENT)
                .enabled(true)
                .build();

        userRepository.save(user);
    }


    public LoginResponse  login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new LoginResponse(token);

    }

}
