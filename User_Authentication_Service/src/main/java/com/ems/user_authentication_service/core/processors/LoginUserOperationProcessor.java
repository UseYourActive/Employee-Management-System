package com.ems.user_authentication_service.core.processors;

import com.ems.user_authentication_service.api.operations.login.LoginUserOperation;
import com.ems.user_authentication_service.api.operations.login.LoginUserRequest;
import com.ems.user_authentication_service.api.operations.login.LoginUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginUserOperationProcessor implements LoginUserOperation {
    @Override
    public LoginUserResponse process(final LoginUserRequest loginUserRequest) {
        return null;
    }
}
