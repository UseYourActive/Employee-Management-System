package com.ems.employee_service.api.operations.find.byzipcode;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByZipCodeRequest implements OperationInput {
    private String zipCode;
}
