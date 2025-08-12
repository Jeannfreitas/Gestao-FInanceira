package com.Jean.GestaoFinanceira.service;

import com.Jean.GestaoFinanceira.Repository.UserRepository;
import com.Jean.GestaoFinanceira.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private String email;

    public User createUser(User user) {
        System.out.println("Email recebido: " + user.getEmail());
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public String getEmail() {
        return this.email;
    }
}
