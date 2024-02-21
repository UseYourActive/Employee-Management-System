package com.ems.employee_service.api.operations.find.byucn;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeeByUniqueCivilianNumberRequest implements OperationInput {
    private String uniqueCivilianNumber;
}
