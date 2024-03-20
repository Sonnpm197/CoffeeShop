package com.coffeeshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "MENUITEM")
@Getter
@Setter
@NoArgsConstructor
public class MenuItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "coffee_shop_id", nullable = false)
    private CoffeeShop coffeeShop;

    @Column
    private String size;

    /**
     * String for flexible settings for prices in different countries, i.e AUD, USD, VND, etc.
     */
    @Column
    private String price;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    private List<Order> orders;
}
