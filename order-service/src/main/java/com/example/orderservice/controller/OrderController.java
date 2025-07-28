package com.example.orderservice.controller;

import com.example.common.dto.order.OrderDTO;
import com.example.common.dto.order.OrderItemDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/by-user/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable("userId") Long userId) {
        return orderService.findOrdersByUserId(userId).stream()
                .map(this::convertToDTO)
                .toList();
    }

    public OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCurrency(order.getCurrency());
        dto.setCreatedAt(order.getCreatedAt());

        if (order.getOrderItems() != null) {
            List<OrderItemDTO> itemDTOs = order.getOrderItems().stream()
                    .map(item -> new OrderItemDTO(
                            item.getId(),
                            item.getProductName(),
                            item.getQuantity(),
                            item.getUnitPrice(),
                            item.getTotalPrice()
                    ))
                    .toList();
            dto.setOrderItems(itemDTOs);
        }
        return dto;
    }
}
