package com.ems.department_service.api.operations.edit.location;

import com.ems.department_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditDepartmentLocationResponse implements OperationOutput {
    private String id;
    private String name;
    private String description;
    private String budget;
    private String location;
    private String phoneNumber;
    private String email;
}
