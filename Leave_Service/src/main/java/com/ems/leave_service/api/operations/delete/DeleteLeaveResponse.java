package com.ems.leave_service.api.operations.delete;

import com.ems.leave_service.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteLeaveResponse implements OperationOutput {
    private Boolean isSuccessful;
}
