package com.ems.user_authentication_service.export;

import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordRequest;
import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordResponse;
import com.ems.user_authentication_service.api.operations.login.LoginUserRequest;
import com.ems.user_authentication_service.api.operations.login.LoginUserResponse;
import com.ems.user_authentication_service.api.operations.register.RegisterUserRequest;
import com.ems.user_authentication_service.api.operations.register.RegisterUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-auth-service", url = "http://localhost:8081")
public interface UserAuthFeignClient {
    @PostMapping("/auth/register")
    RegisterUserResponse registerUser(@RequestBody RegisterUserRequest request);

    @PostMapping("/auth/login")
    LoginUserResponse loginUser(@RequestBody LoginUserRequest request);

    @PatchMapping("/auth/change-password")
    ChangeUserPasswordResponse changePassword(@RequestBody ChangeUserPasswordRequest request);
}
