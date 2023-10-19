package com.prod.accriditationproject.controllers;

import com.prod.accriditationproject.dto.SignInRequest;
import com.prod.accriditationproject.dto.SignInResponse;
import com.prod.accriditationproject.dto.SignUpRequest;
import com.prod.accriditationproject.exception.SignInException;
import com.prod.accriditationproject.exception.SignUpException;
import com.prod.accriditationproject.services.AuthService;
import com.prod.accriditationproject.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final AuthService authService;
    private final TokenService tokenService;

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signinRequest) {
        Optional<User> optionalUser = authService.signIn(signinRequest.username(), signinRequest.password());
        return optionalUser.map(user -> ResponseEntity.ok(
                new SignInResponse( tokenService.generateAccessToken(user), tokenService.generateRefreshToken(user))))
                .orElseThrow(SignInException::new);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest signupDto) {
        return authService.signUp(signupDto.username(), signupDto.email(), signupDto.password(), signupDto.role())
            .map(user -> ResponseEntity.ok("Success"))
                .orElseThrow(SignUpException::new);
    }
}
