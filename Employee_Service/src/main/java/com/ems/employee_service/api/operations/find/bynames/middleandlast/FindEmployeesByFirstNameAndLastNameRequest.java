package com.ems.employee_service.api.operations.find.bynames.middleandlast;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByFirstNameAndLastNameRequest implements OperationInput {
    private String firstName;
    private String lastName;
}
