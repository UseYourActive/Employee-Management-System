package com.ems.employee_service.api.operations.find.bynames.first;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByFirstNameRequest implements OperationInput {
    private String firstName;
}
