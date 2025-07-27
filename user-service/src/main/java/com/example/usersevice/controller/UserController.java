package com.example.usersevice.controller;

import com.example.usersevice.entity.User;
import com.example.usersevice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User getUsers(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }
}
