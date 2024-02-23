package com.ems.user_authentication_service.api.operations.register;

import com.ems.user_authentication_service.api.annotations.validators.StrongPassword;
import com.ems.user_authentication_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest implements OperationInput {
    @Schema(description = "Username", example = "john_doe")
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @StrongPassword
    @Schema(description = "Password", example = "Password123")
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;

    @StrongPassword
    @Schema(description = "Repeated password", example = "Password123")
    @NotBlank(message = "Repeated password is required")
    @Size(min = 8, max = 50, message = "Repeated password must be between 8 and 50 characters")
    private String repeatedPassword;
}
