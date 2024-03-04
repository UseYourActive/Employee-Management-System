package com.ems.leave_service.api.operations.delete;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteLeaveRequest implements OperationInput {
    private String id;
}
