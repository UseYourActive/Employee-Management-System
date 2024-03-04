package com.ems.leave_service.api.operations.create;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLeaveRequest implements OperationInput {
    private String employeeId;
    private String startDate;
    private String endDate;
    private String leaveType;
    private String status;
}
