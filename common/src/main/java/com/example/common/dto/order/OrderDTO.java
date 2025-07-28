package com.example.common.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private Long userId;
    private BigDecimal totalAmount;
    private String currency;
    private List<OrderItemDTO> orderItems;
    private LocalDateTime createdAt;
}
