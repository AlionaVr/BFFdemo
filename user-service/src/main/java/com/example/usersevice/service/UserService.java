package com.example.usersevice.service;

import com.example.usersevice.entity.User;
import com.example.usersevice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

@Transactional(readOnly = true)
    public User getUserById(Long UserId){
        return userRepository.findById(UserId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
