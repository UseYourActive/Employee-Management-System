package com.ems.user_authentication_service.core.processors;

import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordOperation;
import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordRequest;
import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordResponse;
import com.ems.user_authentication_service.core.exceptions.CurrentPasswordInvalidException;
import com.ems.user_authentication_service.persistence.entities.Token;
import com.ems.user_authentication_service.persistence.entities.User;
import com.ems.user_authentication_service.persistence.repositories.TokenRepository;
import com.ems.user_authentication_service.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChangeUserPasswordOperationProcessor implements ChangeUserPasswordOperation {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    @Override
    public ChangeUserPasswordResponse process(final ChangeUserPasswordRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not valid"));

        if (!this.passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new CurrentPasswordInvalidException();
        }

        user.setPassword(this.passwordEncoder.encode(request.getPassword()));
        this.userRepository.save(user);

        tokenRepository.save(
                Token.builder()
                        .token((String) SecurityContextHolder.getContext().getAuthentication().getDetails())
                        .build()
        );

        return ChangeUserPasswordResponse.builder()
                .isSuccessful(Boolean.TRUE)
                .build();
    }
}
