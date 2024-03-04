package com.ems.leave_service.api.operations.find.leave.by_employee_id;

import com.ems.leave_service.api.base.OperationOutput;
import com.ems.leave_service.api.operations.LeaveResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindByEmployeeIdResponse implements OperationOutput {
    private List<LeaveResponseDTO> leaveResponseDTOS;
}
