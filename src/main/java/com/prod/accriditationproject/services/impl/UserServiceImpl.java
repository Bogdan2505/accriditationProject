package com.prod.accriditationproject.services.impl;

import com.prod.accriditationproject.entity.User;
import com.prod.accriditationproject.repository.RoleRepository;
import com.prod.accriditationproject.repository.UserRepository;
import com.prod.accriditationproject.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public boolean existsByUsernameOrEmail(String username, String email) {
        return userRepository.existsByUsernameOrEmail(username, email);
    }

    @Override
    @Transactional
    public User createNewUserAndSave(String userName, String email, String password, String role) {
        return userRepository.save(new User(userName, email, password, Set.of(roleRepository.getRoleByRoleName(role).get())));
    }
}
