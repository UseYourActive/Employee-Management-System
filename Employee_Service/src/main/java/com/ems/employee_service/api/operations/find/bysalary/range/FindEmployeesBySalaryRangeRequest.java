package com.ems.employee_service.api.operations.find.bysalary.range;

import com.ems.employee_service.api.base.OperationInput;

public class FindEmployeesBySalaryRangeRequest implements OperationInput {
    private String minSalary;
    private String maxSalary;
}
