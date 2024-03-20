package com.coffeeshop.mapstruct;

import com.coffeeshop.dto.OrderDTO;
import com.coffeeshop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mapping(target = "quantity", source = "order.quantity")
    @Mapping(target = "orderTime", source = "order.orderTime")
    @Mapping(target = "orderState", source = "order.orderState")
    OrderDTO orderToOrderDTO(Order order);
}
