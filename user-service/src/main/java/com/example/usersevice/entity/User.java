package com.example.usersevice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class User {
    @Id
    private long  id;
    private String username;
    private String address;
    private String phoneNumber;
    private String email;
}
