package com.coffeeshop.model;

import com.coffeeshop.model.enums.OrderState;
import com.coffeeshop.model.enums.converter.OrderStateConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity {

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    @ManyToOne
    @JoinColumn(name = "order_queue_id", nullable = false)
    private OrderQueue orderQueue;

    @Column
    private LocalDateTime orderTime;

    @Column(name = "order_state")
    @Convert(converter = OrderStateConverter.class)
    private OrderState orderState;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

}
