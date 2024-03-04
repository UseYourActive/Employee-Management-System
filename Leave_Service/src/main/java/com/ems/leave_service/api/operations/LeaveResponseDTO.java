package com.ems.leave_service.api.operations;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveResponseDTO {
    private String id;
    private String employeeId;
    private String startDate;
    private String endDate;
    private String leaveType;
    private String status;
}
