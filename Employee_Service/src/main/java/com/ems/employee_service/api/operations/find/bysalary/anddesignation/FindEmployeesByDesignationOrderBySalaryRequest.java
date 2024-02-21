package com.ems.employee_service.api.operations.find.bysalary.anddesignation;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByDesignationOrderBySalaryRequest implements OperationInput {
    private String designation;
}
