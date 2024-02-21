package com.ems.employee_service.api.operations.find.bysalary.greaterthan;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesWithSalaryGreaterThanRequest implements OperationInput {
    private String minSalary;
}
