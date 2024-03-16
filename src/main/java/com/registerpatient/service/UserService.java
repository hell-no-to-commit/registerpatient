package com.registerpatient.service;

import com.registerpatient.entities.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}