package com.example.sitebff.dto;

import com.example.common.dto.order.OrderDTO;
import com.example.common.dto.user.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserWithOrdersDTO {
    private UserDTO user;
    private List<OrderDTO> orders;
}
