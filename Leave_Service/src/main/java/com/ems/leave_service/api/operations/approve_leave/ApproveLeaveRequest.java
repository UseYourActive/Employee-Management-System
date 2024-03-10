package com.ems.leave_service.api.operations.approve_leave;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApproveLeaveRequest implements OperationInput {
    private String id;
}
