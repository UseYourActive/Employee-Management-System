package com.ems.employee_service.api.operations.find.byid;

import com.ems.employee_service.api.base.OperationInput;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindByIdEmployeeRequest implements OperationInput {
    private String id;
}
