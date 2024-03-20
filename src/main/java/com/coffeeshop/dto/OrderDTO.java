package com.coffeeshop.dto;

import com.coffeeshop.model.enums.OrderState;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private int quantity;
    private LocalDateTime orderTime;
    private OrderState orderState;

}
