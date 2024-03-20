package com.coffeeshop.service;

import com.coffeeshop.model.Order;
import com.coffeeshop.repository.OrderQueueRepository;
import com.coffeeshop.repository.OrderRepository;
import com.coffeeshop.model.enums.OrderState;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OperatorService {

    private static final Logger LOG = LoggerFactory.getLogger(OperatorService.class);

    private OrderRepository orderRepository;

    public Order updateOrder(Order updatedOrder) {

        Order order = validateOrder(updatedOrder.getId());

        // if order is completed, cancelled or processing, then skip processing
        if (updatedOrder.getOrderState() == OrderState.INIT) {
            LOG.info("Skip processing orderId: {} with state: {}", updatedOrder.getId(), updatedOrder.getOrderState());
            return order;
        }

        order.setOrderState(updatedOrder.getOrderState());
        order.setDeleted(updatedOrder.isDeleted());
        orderRepository.save(order);

        return order;
    }

    private Order validateOrder(int orderId) {
        // validate wrong data
        Order order = orderRepository.findByIdAndDeletedIsFalse(orderId);

        if (order == null) {
            throw new RuntimeException("Cannot find order with id " + orderId);
        }

        return order;
    }
}
