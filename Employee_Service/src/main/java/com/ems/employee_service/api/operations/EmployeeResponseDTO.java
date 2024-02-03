package com.ems.employee_service.api.operations;

import com.ems.employee_service.api.annotations.validators.ValidUCN;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Schema(description = "Employee Response DTO.")
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class EmployeeResponseDTO {
    @Schema(description = "Unique identifier for the employee.")
    @NotNull(message = "Employee ID cannot be null")
    private String id;

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
    @NotBlank(message = "Unique Civil Number cannot be blank")
    @ValidUCN
    private String uniqueCivilNumber;

    @Schema(description = "Designation of the employee.")
    @NotBlank(message = "Designation cannot be blank")
    private String designation;

    @Schema(description = "Department of the employee.")
    @NotBlank(message = "Department cannot be blank")
    private String department;

    @Schema(description = "Contact information of the employee.")
    @NotNull(message = "Contact information cannot be null")
    private ContactInformationDTO contactInformation;

    @Schema(description = "Salary details of the employee.")
    @NotNull(message = "Salary details cannot be null")
    private SalaryDTO salary;

    @Schema(description = "Creation details of the employee.")
    @NotNull(message = "Creation details cannot be null")
    private CreationDTO creation;

    @Schema(description = "Employee details.")
    @NotNull(message = "Employee details cannot be null")
    private EmployeeDetailsDTO employeeDetails;
}
