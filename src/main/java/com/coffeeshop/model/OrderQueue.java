package com.coffeeshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ORDERQUEUE")
@Getter
@Setter
@NoArgsConstructor
public class OrderQueue extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "coffee_shop_id", nullable = false)
    private CoffeeShop coffeeShop;

    @Column
    private Integer capacity;

    /**
     * For more customizable configs such for take-away orders, special memberships, etc.
     */
    @Column
    private String name;

    /**
     * The higher the more important
     */
    @Column
    private Integer priority;

    @OneToMany(mappedBy = "orderQueue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}
