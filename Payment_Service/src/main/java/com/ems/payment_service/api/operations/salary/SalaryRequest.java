package com.ems.payment_service.api.operations.salary;

import com.ems.payment_service.api.base.OperationInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class SalaryRequest implements OperationInput {
    private String cardNumber;
    private Integer expiryMonth;
    private Integer expiryYear;
    private String cvc;
    private Double cartPrice;
}
