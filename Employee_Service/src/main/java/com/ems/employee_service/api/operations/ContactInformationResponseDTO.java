package com.ems.employee_service.api.operations;

import com.ems.employee_service.api.annotations.validators.ValidPhoneNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Schema(description = "Contact Information DTO.")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactInformationResponseDTO {
    @Schema(description = "Email address of the employee.")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Phone number of the employee.")
    @NotBlank(message = "Phone number cannot be blank")
    @ValidPhoneNumber
    private String phoneNumber;
}
