package com.ems.employee_service.api.operations.find.bygender;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByGenderRequest implements OperationInput {
    private String gender;
}
