package com.ems.department_service.api.operations.find.byid;

import com.ems.department_service.api.base.OperationOutput;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindByIdDepartmentResponse implements OperationOutput {
    private String id;
    private String name;
    private String description;
    private String budget;
    private String location;
    private String phoneNumber;
    private String email;
}
