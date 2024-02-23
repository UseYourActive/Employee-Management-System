package com.ems.user_authentication_service.api.operations.refresh_token;

import com.ems.user_authentication_service.api.base.OperationOutput;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenResponse implements OperationOutput {

    @Schema(description = "The new authentication token.")
    private String newToken;

    @Schema(description = "The refresh token.")
    private String refreshedToken;
}
