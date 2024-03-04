package com.ems.leave_service.api.operations.edit;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditLeaveRequest implements OperationInput {
    private String id;
    private String employeeId;
    private String startDate;
    private String endDate;
    private String leaveType;
    private String status;
}
