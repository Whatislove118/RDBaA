package com.lab2.backend.repository;

import com.lab2.backend.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    void save(User user);
}
