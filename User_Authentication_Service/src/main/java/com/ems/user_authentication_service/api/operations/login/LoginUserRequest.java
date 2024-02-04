package com.ems.user_authentication_service.api.operations.login;

import com.ems.user_authentication_service.api.base.OperationInput;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginUserRequest implements OperationInput {
    @Email
    private String email;
    @NotEmpty
    private String password;
}
