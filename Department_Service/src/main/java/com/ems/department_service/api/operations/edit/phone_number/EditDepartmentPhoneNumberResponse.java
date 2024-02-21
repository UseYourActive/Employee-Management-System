package com.ems.department_service.api.operations.edit.phone_number;

import com.ems.department_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditDepartmentPhoneNumberResponse implements OperationOutput {
    private String id;
    private String name;
    private String description;
    private String budget;
    private String location;
    private String phoneNumber;
    private String email;
}
