package com.example.sitebff.service;

import com.example.common.dto.order.OrderDTO;
import com.example.common.dto.user.UserDTO;
import com.example.sitebff.dto.UserWithOrdersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BffService {

    private final RestTemplate rest;
    @Value("${bff.user-service.url}")
    private String userUrl;
    @Value("${bff.order-service.url}")
    private String orderUrl;

    public UserWithOrdersDTO getUserWithOrders(String userId) {
        UserDTO user = rest.getForObject(userUrl + "/" + userId, UserDTO.class);
        OrderDTO[] arr = rest.getForObject(orderUrl + "/by-user/" + userId, OrderDTO[].class);
        List<OrderDTO> orders = arr == null ? List.of() : Arrays.asList(arr);

        UserWithOrdersDTO out = new UserWithOrdersDTO();
        out.setUser(user);
        out.setOrders(orders);
        return out;
    }
}