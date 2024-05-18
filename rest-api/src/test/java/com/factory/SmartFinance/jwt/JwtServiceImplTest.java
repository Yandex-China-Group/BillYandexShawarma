package com.factory.SmartFinance.jwt;

import com.factory.SmartFinance.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JwtServiceImplTest {

    private final JwtProperties jwtProperties = new JwtProperties();

    private final JwtService jwtService;

    JwtServiceImplTest() {
        jwtProperties.setExpiration(10000000);
        jwtProperties.setSecret("50861a2a1b08cd5f578facf25f0ad207831cafd0800ca9c761c7bf9b8e5510e3");
        jwtService = new JwtServiceImpl(jwtProperties);
    }

    @Test
    void extractLogin() {
        User user = getUser();
        String token = jwtService.generateToken(user);
        assertEquals(user.getLogin(), this.jwtService.extractLogin(token));
    }

    @Test
    void extractId() {
        User user = getUser();
        String token = jwtService.generateToken(user);
        assertEquals(user.getId(), this.jwtService.extractId(token));
    }

    @Test
    void token() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        String token = "Bearer my.jwt.token";
        when(request.getHeader("Authorization")).thenReturn(token);
        Optional<String> extractedToken = jwtService.token(request);
        assertTrue(extractedToken.isPresent());
        assertEquals("my.jwt.token", extractedToken.get());
    }

    @Test
    void isTokenValid() {
        User user = getUser();
        String token = jwtService.generateToken(user);
        assertTrue(this.jwtService.isTokenValid(token, user));
    }

    @Test
    void generateToken() {
        User user = getUser();
        String token = this.jwtService.generateToken(user);
        assertNotNull(token);
    }
    private User getUser() {
        return User.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .surname("Smith")
                .screenName("johnny")
                .login("john.doe")
                .password("password")
                .build();
    }
}