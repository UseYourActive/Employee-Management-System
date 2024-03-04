package com.ems.leave_service.api.operations.find.leave.leaves_by_employee_id_and_date_range;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindLeavesByEmployeeIdAndDateRangeRequest implements OperationInput {
    private String employeeId;
    private String startDate;
    private String endDate;
}
