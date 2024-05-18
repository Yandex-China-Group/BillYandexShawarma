package com.factory.SmartFinance.jwt;

import com.factory.SmartFinance.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JwtService {
    String extractLogin(String token);

    long extractId(String token);

    Optional<String> token(HttpServletRequest request);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(User user);
}
