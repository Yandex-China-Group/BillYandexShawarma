package com.factory.SmartFinance.user.auth;

import com.factory.SmartFinance.jwt.JwtService;
import com.factory.SmartFinance.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public String auth(String login, String password) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        password
                )
        );

        return jwtService.generateToken(userService.user(login));
    }
}
