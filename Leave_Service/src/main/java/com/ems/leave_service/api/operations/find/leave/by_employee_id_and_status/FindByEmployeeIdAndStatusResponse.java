package com.ems.leave_service.api.operations.find.leave.by_employee_id_and_status;

import com.ems.leave_service.api.base.OperationOutput;
import com.ems.leave_service.api.operations.LeaveResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindByEmployeeIdAndStatusResponse implements OperationOutput {
    private List<LeaveResponseDTO> leaveResponseDTOS;
}
