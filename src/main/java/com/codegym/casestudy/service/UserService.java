package com.codegym.casestudy.service;

import com.codegym.casestudy.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void remove(Long id);
}
