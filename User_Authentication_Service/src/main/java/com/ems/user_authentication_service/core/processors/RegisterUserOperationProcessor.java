package com.ems.user_authentication_service.core.processors;

import com.ems.user_authentication_service.api.operations.register.RegisterUserOperation;
import com.ems.user_authentication_service.api.operations.register.RegisterUserRequest;
import com.ems.user_authentication_service.api.operations.register.RegisterUserResponse;
import com.ems.user_authentication_service.persistence.entities.User;
import com.ems.user_authentication_service.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterUserOperationProcessor implements RegisterUserOperation {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public RegisterUserResponse process(final RegisterUserRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        User savedUser = userRepository.save(user);

        return RegisterUserResponse.builder()
                .id(String.valueOf(savedUser.getId()))
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .phoneNumber(savedUser.getPhoneNumber())
                .build();
    }
}
