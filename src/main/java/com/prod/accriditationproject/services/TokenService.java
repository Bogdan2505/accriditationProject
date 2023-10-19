package com.prod.accriditationproject.services;

import org.springframework.security.core.userdetails.User;

public interface TokenService {

    String generateAccessToken(User user);

    String generateRefreshToken(User user);

    String parseToken(String token);
}
