package com.ems.user_authentication_service.api.operations.changepassword;

import com.ems.user_authentication_service.api.base.OperationOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ChangeUserPasswordResponse implements OperationOutput {
    private Boolean isSuccessful;
}
