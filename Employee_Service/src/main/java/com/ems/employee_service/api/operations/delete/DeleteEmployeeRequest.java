package com.ems.employee_service.api.operations.delete;

import com.ems.employee_service.api.base.OperationInput;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteEmployeeRequest implements OperationInput {
    private String id;
}
