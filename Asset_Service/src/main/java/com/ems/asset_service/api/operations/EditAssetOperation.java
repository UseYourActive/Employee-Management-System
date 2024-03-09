package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

public interface EditAssetOperation extends OperationProcessor<EditAssetOperation.EditAssetResponse, EditAssetOperation.EditAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditAssetResponse implements OperationOutput  {
        @Schema(description = "ID of the edited asset", example = "123e4567-e89b-12d3-a456-556642440000")
        private String id;

        @Schema(description = "Updated name of the asset")
        private String name;

        @Schema(description = "Updated description of the asset")
        private String description;

        @Schema(description = "Updated serial number of the asset")
        private String serialNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditAssetRequest implements OperationInput {
        @Schema(description = "ID of the asset to edit", example = "123e4567-e89b-12d3-a456-556642440000", required = true)
        @NotBlank(message = "ID must not be blank")
        private String id;

        @Schema(description = "New name for the asset")
        private String name;

        @Schema(description = "New description for the asset")
        private String description;

        @Schema(description = "New serial number for the asset")
        private String serialNumber;
    }
}
