package com.ems.employee_service.api.operations.find.bynames.last;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByLastNameRequest implements OperationInput {
    private String lastName;
}
