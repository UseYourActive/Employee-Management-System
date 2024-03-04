package com.ems.leave_service.api.operations.find.leave.by_employee_id_and_status;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindByEmployeeIdAndStatusRequest implements OperationInput {
    private String employeeId;
    private String status;
}
