package com.ems.employee_service.api.operations.create;

import com.ems.employee_service.api.base.OperationInput;
import com.ems.employee_service.api.operations.ContactInformationResponseDTO;
import com.ems.employee_service.api.operations.EmployeeDetailsResponseDTO;
import com.ems.employee_service.api.operations.SalaryResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewEmployeeRequest implements OperationInput {
    @Schema(description = "First name of the employee.")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @Schema(description = "Middle name of the employee.")
    @NotBlank(message = "Middle name cannot be blank")
    private String middleName;

    @Schema(description = "Last name of the employee.")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Schema(description = "Unique Civil Number of the employee.")
    //@ValidUCN
    private String uniqueCivilNumber;

    @Schema(description = "Designation of the employee.")
    @NotBlank(message = "Designation cannot be blank")
    private String designation;

    @Schema(description = "Department of the employee.")
    @NotBlank(message = "Department cannot be blank")
    private String department;

    @Schema(description = "Contact information of the employee.")
    @NotNull(message = "Contact information cannot be null")
    private ContactInformationResponseDTO contactInformation;

    @Schema(description = "Salary details of the employee.")
    @NotNull(message = "Salary details cannot be null")
    private SalaryResponseDTO salary;

    @Schema(description = "Employee details.")
    @NotNull(message = "Employee details cannot be null")
    private EmployeeDetailsResponseDTO employeeDetails;
}
