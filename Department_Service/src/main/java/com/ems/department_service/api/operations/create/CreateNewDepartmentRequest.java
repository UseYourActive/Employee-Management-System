package com.ems.department_service.api.operations.create;

import com.ems.department_service.api.annotations.validators.ValidBigDecimal;
import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewDepartmentRequest implements OperationInput {

    @NotBlank(message = "Name must not be blank")
    @Schema(description = "Name of the department", example = "Engineering")
    private String name;

    @NotBlank(message = "Description must not be blank")
    @Schema(description = "Description of the department", example = "Responsible for software development")
    private String description;

    @NotNull(message = "Budget must not be null")
    @ValidBigDecimal
    @Schema(description = "Budget of the department", example = "10000.00")
    private String budget;

    @NotBlank(message = "Location must not be blank")
    @Schema(description = "Location of the department", example = "New York")
    private String location;

    @NotBlank(message = "Phone number must not be blank")
    @Schema(description = "Phone number of the department", example = "123-456-7890")
    private String phoneNumber;

    @NotBlank(message = "Email must not be blank")
    @Schema(description = "Email of the department", example = "engineering@example.com")
    private String email;
}
