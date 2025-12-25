package com.example.recepie.service;

import com.example.recepie.model.User;
import com.example.recepie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
    public User authenticate(String username, String passwordHash) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPasswordHash().equals(passwordHash)) {
            return user;
        }
        return null;
    }
}
