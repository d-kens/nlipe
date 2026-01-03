package com.peid.modules.auth.service;

import com.peid.modules.users.dto.UserResponse;
import com.peid.security.service.JwtService;
import com.peid.modules.auth.dto.AuthRequest;
import com.peid.modules.auth.dto.AuthResponse;
import com.peid.modules.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private JwtService jwtService;
    private UserService userService;
    private AuthenticationManager authenticationManager;

    public AuthResponse login(AuthRequest authRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );

        var user = userService.getUserByEmail(authRequest.getEmail());

        var accessTokenObject = jwtService.generateAccessToken(user);
        var refreshTokenObject = jwtService.generateRefreshToken(user);


        return new AuthResponse(
                accessTokenObject.toString(),
                refreshTokenObject.toString()
        );
    }

    public String refreshToken(String refreshToken) {
        var refreshTokenObject = jwtService.parseToken(refreshToken);

        if (refreshTokenObject == null || refreshTokenObject.isExpired())
            return null;


        var userEmail = refreshTokenObject.getUserEmail();
        var user = userService.getUserByEmail(userEmail);

        var accessTokenObject = jwtService.generateRefreshToken(user);
        return accessTokenObject.toString();

    }

    public UserResponse getCurrentUser(Long userId) {
        return userService.getUserById(userId);
    }
}