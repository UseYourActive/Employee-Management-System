package com.ems.payment_service.api.operations.salary;

import com.ems.payment_service.api.base.OperationOutput;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SalaryResponse implements OperationOutput {
    private Boolean isSuccessful;
}
