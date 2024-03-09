package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

public interface FindByIdAssetOperation extends OperationProcessor<FindByIdAssetOperation.FindByIdAssetResponse, FindByIdAssetOperation.FindByIdAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdAssetResponse implements OperationOutput  {
        @Schema(description = "ID of the asset")
        private String id;

        @Schema(description = "Name of the asset")
        private String name;

        @Schema(description = "Description of the asset")
        private String description;

        @Schema(description = "Serial number of the asset")
        private String serialNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdAssetRequest implements OperationInput {
        @Schema(description = "ID of the asset to find", required = true)
        @NotBlank(message = "ID must not be blank")
        private String id;
    }
}
