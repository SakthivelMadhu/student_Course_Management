package com.example.service;


import com.example.dto.UserDTO;

public interface AuthService {

    void registerUser(UserDTO userDTO);

    boolean login(String username, String password);
}

