package com.ems.employee_service.api.operations.find.byphonenumber;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeeByPhoneNumberRequest implements OperationInput {
    private String phoneNumber;
}
