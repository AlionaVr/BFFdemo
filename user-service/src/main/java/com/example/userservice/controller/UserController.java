package com.example.userservice.controller;

import com.example.common.dto.user.UserDTO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
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
    public UserDTO getUsers(@PathVariable("userId") Long userId) {
        User u = userService.getUserById(userId);
        return new UserDTO(
                u.getId(), u.getUsername(), u.getAddress(),
                u.getPhoneNumber(), u.getEmail()
        );
    }
}
