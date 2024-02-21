package com.ems.employee_service.api.operations.find.bymaritalstatus;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByEmployeeDetailsMaritalStatusRequest implements OperationInput {
    private String maritalStatus;
}
