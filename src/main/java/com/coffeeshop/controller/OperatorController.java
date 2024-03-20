package com.coffeeshop.controller;

import com.coffeeshop.dto.OrderDTO;
import com.coffeeshop.mapstruct.OrderMapper;
import com.coffeeshop.model.Order;
import com.coffeeshop.service.OperatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coffeeshop/operator")
@AllArgsConstructor
public class OperatorController {

    private OperatorService operatorService;
    private OrderMapper orderMapper;

    @PatchMapping("update-order")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody Order updatedOrder) {
        return new ResponseEntity<>(orderMapper.orderToOrderDTO(operatorService.updateOrder(updatedOrder)), HttpStatus.OK);
    }

}