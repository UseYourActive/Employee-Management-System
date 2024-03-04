package com.ems.leave_service.api.operations.find.leave.leaves_by_employee_id_and_date_range;

import com.ems.leave_service.api.base.OperationOutput;
import com.ems.leave_service.api.operations.LeaveResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindLeavesByEmployeeIdAndDateRangeResponse implements OperationOutput {
    private List<LeaveResponseDTO> leaveResponseDTOS;
}
