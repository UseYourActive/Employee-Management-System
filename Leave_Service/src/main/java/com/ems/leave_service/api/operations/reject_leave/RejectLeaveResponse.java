package com.ems.leave_service.api.operations.reject_leave;

import com.ems.leave_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RejectLeaveResponse implements OperationOutput {
    private Boolean isSuccessfullyRejected;
}
