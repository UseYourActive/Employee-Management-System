package com.ems.department_service.api.operations.delete;

import com.ems.department_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDepartmentRequest implements OperationInput {
    private String id;
}
