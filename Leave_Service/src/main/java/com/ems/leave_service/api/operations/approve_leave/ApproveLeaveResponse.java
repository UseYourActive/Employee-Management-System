package com.ems.leave_service.api.operations.approve_leave;

import com.ems.leave_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApproveLeaveResponse implements OperationOutput {
    private Boolean successfullyApprovedLeave;
}
