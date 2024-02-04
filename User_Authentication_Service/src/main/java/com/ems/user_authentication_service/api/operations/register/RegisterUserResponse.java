package com.ems.user_authentication_service.api.operations.register;

import com.ems.user_authentication_service.api.base.OperationOutput;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserResponse implements OperationOutput {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String credit;
}
