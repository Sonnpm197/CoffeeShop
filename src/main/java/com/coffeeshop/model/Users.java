package com.coffeeshop.model;

import com.coffeeshop.model.enums.UserRole;
import com.coffeeshop.model.enums.converter.UserRoleConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class Users extends BaseEntity {

    @Column
    private String address;

    @Column
    private String name;

    @Column(name = "user_role")
    @Convert(converter = UserRoleConverter.class)
    private UserRole userRole;

    /**
     * To verify how many number of times this user has ordered successfully
     */
    @Column(name = "success_orders")
    private int successOrders;

    @Column
    private String mobileNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
}
