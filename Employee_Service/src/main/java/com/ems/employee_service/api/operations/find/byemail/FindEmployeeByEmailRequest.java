package com.ems.employee_service.api.operations.find.byemail;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeeByEmailRequest implements OperationInput {
    private String email;
}
