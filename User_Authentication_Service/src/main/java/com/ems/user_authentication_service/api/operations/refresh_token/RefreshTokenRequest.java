package com.ems.user_authentication_service.api.operations.refresh_token;

import com.ems.user_authentication_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenRequest implements OperationInput {
    @NotBlank(message = "Refresh token must not be blank")
    @Schema(description = "The refresh token to be used for refreshing the authentication token.")
    private String token;
}
