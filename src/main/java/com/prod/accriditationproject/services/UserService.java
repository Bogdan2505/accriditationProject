package com.prod.accriditationproject.services;

import com.prod.accriditationproject.entity.User;

public interface UserService {

    boolean existsByUsernameOrEmail(String username, String email);


    User createNewUserAndSave(String userName, String email, String password, String role);
}
