package com.ems.user_authentication_service.core.processors;

import com.ems.user_authentication_service.api.operations.register.RegisterUserOperation;
import com.ems.user_authentication_service.api.operations.register.RegisterUserRequest;
import com.ems.user_authentication_service.api.operations.register.RegisterUserResponse;
import com.ems.user_authentication_service.core.mappers.RegisterUserMapper;
import com.ems.user_authentication_service.persistence.entities.User;
import com.ems.user_authentication_service.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterUserOperationProcessor implements RegisterUserOperation {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserMapper userMapper;

    @Override
    public RegisterUserResponse process(final RegisterUserRequest request) {
        log.info("Processing registration for user with email: {}", request.getEmail());

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        log.debug("Saving user to the database: {}", user);
        User savedUser = userRepository.save(user);

        RegisterUserResponse response = userMapper.convert(savedUser);

        log.info("User registration completed successfully. User details: {}", response);
        return response;
    }
}
