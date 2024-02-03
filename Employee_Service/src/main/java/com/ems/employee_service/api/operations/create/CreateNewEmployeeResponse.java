package com.ems.employee_service.api.operations.create;

import com.ems.employee_service.api.base.OperationOutput;
import com.ems.employee_service.api.operations.ContactInformationResponseDTO;
import com.ems.employee_service.api.operations.CreationResponseDTO;
import com.ems.employee_service.api.operations.EmployeeDetailsResponseDTO;
import com.ems.employee_service.api.operations.SalaryResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewEmployeeResponse implements OperationOutput {
    @Schema(description = "Unique identification number of the employee.")
    private String id;

    @Schema(description = "First name of the employee.")
    private String firstName;

    @Schema(description = "Middle name of the employee.")
    private String middleName;

    @Schema(description = "Last name of the employee.")
    private String lastName;

    @Schema(description = "Unique Civil Number of the employee.")
    private String uniqueCivilNumber;

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
