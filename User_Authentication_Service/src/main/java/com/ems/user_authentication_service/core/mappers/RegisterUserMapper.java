package com.ems.user_authentication_service.core.mappers;

import com.ems.user_authentication_service.api.operations.register.RegisterUserResponse;
import com.ems.user_authentication_service.persistence.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegisterUserMapper implements Converter<User, RegisterUserResponse> {
    @Override
    public RegisterUserResponse convert(User source) {
        log.debug("Converting User to RegisterUserResponse: {}", source);

        RegisterUserResponse response = RegisterUserResponse.builder()
                .id(String.valueOf(source.getId()))
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .phoneNumber(source.getPhoneNumber())
                .build();

        log.debug("Conversion successful. Result: {}", response);
        return response;
    }
}
