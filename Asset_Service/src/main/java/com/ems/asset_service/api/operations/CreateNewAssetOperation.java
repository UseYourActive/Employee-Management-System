package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import lombok.*;

import java.util.UUID;

public interface CreateNewAssetOperation extends OperationProcessor<CreateNewAssetOperation.CreateNewAssetResponse, CreateNewAssetOperation.CreateNewAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAssetResponse implements OperationOutput {
        private String id;
        private String name;
        private String description;
        private String serialNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAssetRequest implements OperationInput {
    private String name;
    private String description;
    private String serialNumber;
    }
}
