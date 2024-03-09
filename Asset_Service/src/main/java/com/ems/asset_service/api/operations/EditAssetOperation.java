package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import lombok.*;

import java.util.UUID;

public interface EditAssetOperation extends OperationProcessor<EditAssetOperation.EditAssetResponse, EditAssetOperation.EditAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditAssetResponse implements OperationOutput  {
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
    class EditAssetRequest implements OperationInput {
    private String id;
    private String name;
    private String description;
    private String serialNumber;
    }
}
