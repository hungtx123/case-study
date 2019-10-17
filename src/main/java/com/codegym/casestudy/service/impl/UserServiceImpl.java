package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.User;
import com.codegym.casestudy.repository.UserRepository;
import com.codegym.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserServiceImpl implements UserService {
        @Autowired
        UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
        public Iterable<User> findAll() {
            return userRepository.findAll();
        }

        @Override
        public Optional<User> findById(Long id) {
            return userRepository.findById(id);
        }

        @Override
        public void save(User user) {
            userRepository.save(user);
        }

        @Override
        public void remove(Long id) {
            userRepository.deleteById(id);
        }

    @Override
    public Page<User> findAllByFirstNameContaining(String name, Pageable pageable) {
        return null;
    }
}
