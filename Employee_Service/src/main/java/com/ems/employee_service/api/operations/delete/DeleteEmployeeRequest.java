package com.ems.employee_service.api.operations.delete;

import com.ems.employee_service.api.base.OperationInput;
import lombok.Getter;

@Getter
public class DeleteEmployeeRequest implements OperationInput {
    private String id;
}
