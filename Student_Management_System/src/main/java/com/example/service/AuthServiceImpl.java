package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Hash the password before storing it in the database
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());

        // Create a new user entity and save it to the database
        User user = new User(userDTO.getUsername(), hashedPassword);
        userRepository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        // Find the user by username
        User user = userRepository.findByUsername(username);

        // Check if the user exists
        if (user == null) {
            return false;
        }

        // Verify the provided password against the hashed password in the database
        return passwordEncoder.matches(password, user.getPassword());
    }
}

