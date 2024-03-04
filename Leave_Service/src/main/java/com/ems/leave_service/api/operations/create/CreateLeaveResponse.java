package com.ems.leave_service.api.operations.create;

import com.ems.leave_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLeaveResponse implements OperationOutput {
    private String id;
    private String employeeId;
    private String startDate;
    private String endDate;
    private String leaveType;
    private String status;
}
