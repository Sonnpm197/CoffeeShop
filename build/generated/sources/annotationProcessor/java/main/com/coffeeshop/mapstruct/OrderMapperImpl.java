package com.coffeeshop.mapstruct;

import com.coffeeshop.dto.OrderDTO;
import com.coffeeshop.model.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T13:04:21+1100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO orderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setQuantity( order.getQuantity() );
        orderDTO.setOrderTime( order.getOrderTime() );
        orderDTO.setOrderState( order.getOrderState() );

        return orderDTO;
    }
}
