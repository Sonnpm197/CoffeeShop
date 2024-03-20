package com.coffeeshop.model.enums.converter;

import com.coffeeshop.model.enums.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole role) {
        if (role == null) {
            return null;
        }
        return role.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String role) {
        if (role == null) {
            return null;
        }

        return Stream.of(UserRole.values())
                .filter(c -> c.name().equals(role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}