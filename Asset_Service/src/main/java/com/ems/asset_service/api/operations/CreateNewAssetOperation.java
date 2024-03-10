package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

public interface CreateNewAssetOperation extends OperationProcessor<CreateNewAssetOperation.CreateNewAssetResponse, CreateNewAssetOperation.CreateNewAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAssetResponse implements OperationOutput {
        @Schema(description = "ID of the created asset")
        private String id;

        @Schema(description = "Name of the asset")
        private String name;

        @Schema(description = "Description of the asset")
        private String description;

        @Schema(description = "Serial number of the asset")
        private String serialNumber;

        @Schema(description = "Type of the asset")
        private String assetType;

        @Schema(description = "Status of the asset")
        private String assetStatus;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAssetRequest implements OperationInput {
        @Schema(description = "Name of the asset", required = true)
        @NotBlank(message = "Name must not be blank")
        @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
        private String name;

        @Schema(description = "Description of the asset", required = true)
        @NotBlank(message = "Description must not be blank")
        private String description;

        @Schema(description = "Serial number of the asset", required = true)
        @NotBlank(message = "Serial number must not be blank")
        private String serialNumber;

        @Schema(description = "Type of the asset", required = true)
        @NotBlank(message = "Type must not be blank")
        private String assetType;
    }
}
