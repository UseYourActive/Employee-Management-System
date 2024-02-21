package com.ems.employee_service.api.operations.find.byid;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindByIdEmployeeRequest implements OperationInput {
    private String id;
}
