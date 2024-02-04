package com.ems.user_authentication_service.api.operations.login;

import com.ems.user_authentication_service.api.base.OperationOutput;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserResponse implements OperationOutput {
    private String jwt;
}
