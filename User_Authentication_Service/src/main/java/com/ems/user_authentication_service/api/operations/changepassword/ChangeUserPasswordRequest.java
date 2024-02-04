package com.ems.user_authentication_service.api.operations.changepassword;

import com.ems.user_authentication_service.api.base.OperationInput;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ChangeUserPasswordRequest implements OperationInput {
    @NotEmpty
    private String oldPassword;

    @NotEmpty
    private String password;
}
