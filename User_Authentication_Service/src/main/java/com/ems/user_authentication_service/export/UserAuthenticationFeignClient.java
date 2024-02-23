package com.ems.user_authentication_service.export;

import com.ems.user_authentication_service.api.operations.change_password.ChangeUserPasswordRequest;
import com.ems.user_authentication_service.api.operations.change_password.ChangeUserPasswordResponse;
import com.ems.user_authentication_service.api.operations.login.LoginRequest;
import com.ems.user_authentication_service.api.operations.login.LoginResponse;
import com.ems.user_authentication_service.api.operations.register.RegisterRequest;
import com.ems.user_authentication_service.api.operations.register.RegisterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-AUTHENTICATION-SERVICE")
public interface UserAuthenticationFeignClient {
    @PostMapping("/auth/register")
    RegisterResponse registerUser(@RequestBody RegisterRequest request);

    @PostMapping("/auth/login")
    LoginResponse loginUser(@RequestBody LoginRequest request);

    @PatchMapping("/auth/change-password")
    ChangeUserPasswordResponse changePassword(@RequestBody ChangeUserPasswordRequest request);
}
