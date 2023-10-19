package com.prod.accriditationproject.services.impl;

import com.prod.accriditationproject.repository.RoleRepository;
import com.prod.accriditationproject.services.AuthService;
import com.prod.accriditationproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;


    @Override
    public Optional<User> signIn(String userName, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userName, password);
        authenticationManager.authenticate(authenticationToken);

        return Optional.of((User) userDetailsService.loadUserByUsername(userName));
    }

    @Override
    public Optional<com.prod.accriditationproject.entity.User> signUp(String userName, String email, String password, String role) {
        if (isValid(userName, email, role)) {
            return Optional.of(userService.createNewUserAndSave(userName, email, password, role));
        }
        return Optional.empty();
    }

    private boolean isValid(String userName, String email, String role) {
        return !userName.isEmpty()
                && !email.isEmpty()
                && !role.isEmpty()
                && roleRepository.existsByRoleName(role)
                && userService.existsByUsernameOrEmail(userName, email);
    }
}
