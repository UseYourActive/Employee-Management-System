package com.ems.employee_service.api.operations.find.bydesignation;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByDesignationRequest implements OperationInput {
    private String designation;
}
