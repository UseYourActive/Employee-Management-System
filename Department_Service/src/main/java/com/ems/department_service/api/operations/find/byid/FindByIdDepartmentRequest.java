package com.ems.department_service.api.operations.find.byid;

import com.ems.department_service.api.base.OperationInput;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FindByIdDepartmentRequest implements OperationInput {
    private String id;
}
