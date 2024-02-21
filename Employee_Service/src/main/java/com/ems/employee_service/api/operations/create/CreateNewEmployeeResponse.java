package com.ems.employee_service.api.operations.create;

import com.ems.employee_service.api.base.OperationOutput;
import com.ems.employee_service.api.operations.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewEmployeeResponse implements OperationOutput {
    @Schema(description = "Unique identification number of the employee.")
    private String id;

    @Schema(description = "Personal information of the employee.")
    @NotBlank(message = "Personal information cannot be blank")
    private PersonalInformationResponseDTO personalInformation;

    @Schema(description = "Designation of the employee.")
    private String designation;

    @Schema(description = "Department of the employee.")
    private String department;

    @Schema(description = "Contact information of the employee.")
    private ContactInformationResponseDTO contactInformation;

    @Schema(description = "Salary details of the employee.")
    private SalaryResponseDTO salary;

    @Schema(description = "Creation details of the employee.")
    private CreationResponseDTO creation;

    @Schema(description = "Employee details.")
    private EmployeeDetailsResponseDTO employeeDetails;
}
