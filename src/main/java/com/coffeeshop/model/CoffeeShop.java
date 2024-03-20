package com.coffeeshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "COFFEESHOP")
@Getter
@Setter
@NoArgsConstructor
public class CoffeeShop extends BaseEntity {

    @Column
    private String longitude;

    @Column
    private String latitude;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String address;

    @OneToMany(mappedBy = "coffeeShop", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "coffeeShop", cascade = CascadeType.ALL)
    private List<OrderQueue> orderQueues;
}
