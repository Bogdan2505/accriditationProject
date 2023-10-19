package com.prod.accriditationproject.services;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface AuthService {
    Optional<User> signIn(String userName, String password);

    Optional<com.prod.accriditationproject.entity.User> signUp(String userName, String email, String password, String role);
}
