package com.ems.employee_service.api.operations;

import com.ems.employee_service.api.annotations.validators.ValidBigDecimal;
import com.ems.employee_service.api.annotations.validators.ValidDate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Schema(description = "Salary DTO.")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryResponseDTO {
    @Schema(description = "Amount of the salary.")
    @NotNull(message = "Amount cannot be null")
    @ValidBigDecimal
//    @DecimalMin(value = "0.0", inclusive = false, message = "Salary amount must be greater than 0")
    private String amount;

    @Schema(description = "Effective date of the salary.")
    @NotNull(message = "Effective date cannot be null")
    @ValidDate
    private String effectiveDate;
}
