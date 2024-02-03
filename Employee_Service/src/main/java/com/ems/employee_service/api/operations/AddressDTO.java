package com.ems.employee_service.api.operations;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Schema(description = "Address DTO.")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    @Schema(description = "Street of the address.")
    @NotBlank(message = "Street cannot be blank")
    private String street;

    @Schema(description = "City of the address.")
    @NotBlank(message = "City cannot be blank")
    private String city;

    @Schema(description = "Zip code of the address.")
    @NotBlank(message = "Zip code cannot be blank")
    private String zipCode;
}
