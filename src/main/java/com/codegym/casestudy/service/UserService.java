package com.codegym.casestudy.service;

import com.codegym.casestudy.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void remove(Long id);
    Page<User> findAllByFirstNameContaining(String name, Pageable pageable);

}
