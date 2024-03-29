package com.ems.employee_service.api.operations.find.bydateofbirth;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByDateOfBirthBetweenRequest implements OperationInput {
    private String startDate;
    private String endDate;
}
