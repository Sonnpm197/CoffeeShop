package com.coffeeshop.model.enums.converter;

import com.coffeeshop.model.enums.OrderState;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStateConverter implements AttributeConverter<OrderState, String> {

    @Override
    public String convertToDatabaseColumn(OrderState state) {
        if (state == null) {
            return null;
        }
        return state.name();
    }

    @Override
    public OrderState convertToEntityAttribute(String state) {
        if (state == null) {
            return null;
        }

        return Stream.of(OrderState.values())
                .filter(c -> c.name().equals(state))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}