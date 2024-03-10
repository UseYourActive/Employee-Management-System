package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public interface AssignAssetToEmployeeOperation extends OperationProcessor<AssignAssetToEmployeeOperation.AssignAssetToEmployeeResponse, AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class AssignAssetToEmployeeResponse implements OperationOutput {
        @Schema(description = "ID of the edited asset", example = "123e4567-e89b-12d3-a456-556642440000")
        private String id;

        @Schema(description = "Employee ID")
        private String employeeId;

        @Schema(description = "Updated name of the asset")
        private String name;

        @Schema(description = "Updated description of the asset")
        private String description;

        @Schema(description = "Updated serial number of the asset")
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
    class AssignAssetToEmployeeRequest implements OperationInput {
        private String employeeId;
        private String assetId;
    }
}
