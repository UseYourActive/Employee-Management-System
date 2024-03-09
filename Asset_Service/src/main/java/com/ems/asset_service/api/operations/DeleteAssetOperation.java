package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import lombok.*;

public interface DeleteAssetOperation extends OperationProcessor<DeleteAssetOperation.DeleteAssetResponse, DeleteAssetOperation.DeleteAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class DeleteAssetResponse implements OperationOutput {
        private Boolean isSuccessfullyDeleted;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class DeleteAssetRequest implements OperationInput {
        private String id;
    }
}
