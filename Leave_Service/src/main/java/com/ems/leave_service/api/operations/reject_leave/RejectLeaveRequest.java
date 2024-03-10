package com.ems.leave_service.api.operations.reject_leave;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RejectLeaveRequest implements OperationInput {
    private String id;
}
