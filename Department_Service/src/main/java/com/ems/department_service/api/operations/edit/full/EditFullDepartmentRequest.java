package com.ems.department_service.api.operations.edit.full;

import com.ems.department_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditFullDepartmentRequest implements OperationInput {
    private String id;
    private String name;
    private String description;
    private String budget;
    private String location;
    private String phoneNumber;
    private String email;
}
