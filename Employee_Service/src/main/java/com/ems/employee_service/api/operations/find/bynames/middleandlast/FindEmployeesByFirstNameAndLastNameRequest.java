package com.ems.employee_service.api.operations.find.bynames.middleandlast;

import com.ems.employee_service.api.base.OperationInput;

public class FindEmployeesByFirstNameAndLastNameRequest implements OperationInput {
    private String firstName;
    private String lastName;
}
