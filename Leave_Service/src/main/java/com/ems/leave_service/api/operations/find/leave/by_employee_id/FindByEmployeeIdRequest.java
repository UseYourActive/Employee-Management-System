package com.ems.leave_service.api.operations.find.leave.by_employee_id;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindByEmployeeIdRequest implements OperationInput {
    private String employeeId;
}
