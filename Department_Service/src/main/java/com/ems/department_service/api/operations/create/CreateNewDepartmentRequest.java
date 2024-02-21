package com.ems.department_service.api.operations.create;

import com.ems.department_service.api.annotations.validators.ValidBigDecimal;
import com.ems.department_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewDepartmentRequest implements OperationInput {
    private String name;
    private String description;
    @ValidBigDecimal
    private String budget;
    private String location;
    private String phoneNumber;
    private String email;
}
