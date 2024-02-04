package com.ems.user_authentication_service.rest.controllers;

import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordOperation;
import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordRequest;
import com.ems.user_authentication_service.api.operations.changepassword.ChangeUserPasswordResponse;
import com.ems.user_authentication_service.api.operations.login.LoginUserOperation;
import com.ems.user_authentication_service.api.operations.login.LoginUserRequest;
import com.ems.user_authentication_service.api.operations.login.LoginUserResponse;
import com.ems.user_authentication_service.api.operations.register.RegisterUserOperation;
import com.ems.user_authentication_service.api.operations.register.RegisterUserRequest;
import com.ems.user_authentication_service.api.operations.register.RegisterUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class UserController {
    private final RegisterUserOperation registerUserOperation;
    private final LoginUserOperation loginUserOperation;
    private final ChangeUserPasswordOperation changeUserPasswordOperation;

    @PostMapping(path = "/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "User registered successfully."),
            @ApiResponse(responseCode = "400",description = "Invalid field contents.")
    })
    @Operation(description = "Registers a new user.",
            summary = "Registers a new user.")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody @Valid RegisterUserRequest input) {
        return new ResponseEntity<>(registerUserOperation.process(input), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Login successful."),
            @ApiResponse(responseCode = "400",description = "Invalid field contents."),
            @ApiResponse(responseCode = "403",description = "Invalid credentials.")
    })
    @Operation(description = "Checks credentials and returns JWT in response header.",
            summary = "Login with email and password.")
    public ResponseEntity<LoginUserResponse> loginUser(@RequestBody @Valid LoginUserRequest input) {
        LoginUserResponse result = loginUserOperation.process(input);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", result.getJwt());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Password changed successfully."),
            @ApiResponse(responseCode = "400",description = "Current or new password is empty."),
            @ApiResponse(responseCode = "403",description = "Current password is invalid or token is blacklisted.")
    })
    @PatchMapping(path = "/change-password")
    @Operation(description = "Changes the password of the currently logged user and ends current session.",
            summary = "Changes current password and invalidates current jwt.")
    //@SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ChangeUserPasswordResponse> changePassword(@RequestBody @Valid ChangeUserPasswordRequest input) {
        return ResponseEntity.ok(changeUserPasswordOperation.process(input));
    }
}
