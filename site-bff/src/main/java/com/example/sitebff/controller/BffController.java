package com.example.sitebff.controller;

import com.example.sitebff.dto.UserWithOrdersDTO;
import com.example.sitebff.service.BffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/site-bff")
@RequiredArgsConstructor
public class BffController {

    private final BffService bff;

    @GetMapping("/user/{userId}")
    public UserWithOrdersDTO  getUserOrders (@PathVariable ("userId") String userId) {
        return bff.getUserWithOrders(userId);
    }
}
