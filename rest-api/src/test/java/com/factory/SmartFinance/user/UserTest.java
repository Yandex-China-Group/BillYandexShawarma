package com.factory.SmartFinance.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = User.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .surname("Smith")
                .screenName("johnny")
                .login("john.doe")
                .password("password")
                .build();
    }

    @Test
    void getAuthorities() {
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    void getUsername() {
        assertEquals("john.doe", user.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    void isEnabled() {
        assertTrue(user.isEnabled());
    }
}