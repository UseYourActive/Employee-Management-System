package com.ems.department_service.api.operations.delete;

import com.ems.department_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDepartmentResponse implements OperationOutput {
    private Boolean successfullyDeletedDepartment;
}
