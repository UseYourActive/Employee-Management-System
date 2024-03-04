package com.ems.leave_service.api.operations.find.leave.all;

import com.ems.leave_service.api.base.OperationOutput;
import com.ems.leave_service.api.operations.LeaveResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindAllLeavesResponse implements OperationOutput {
    private List<LeaveResponseDTO> leaveResponseDTOS;
}
