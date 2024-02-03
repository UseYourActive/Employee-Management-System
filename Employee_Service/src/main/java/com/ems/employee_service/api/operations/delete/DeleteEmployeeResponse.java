package com.ems.employee_service.api.operations.delete;

import com.ems.employee_service.api.base.OperationOutput;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteEmployeeResponse implements OperationOutput {
    private Boolean successfullyDeletedEmployee;
}
