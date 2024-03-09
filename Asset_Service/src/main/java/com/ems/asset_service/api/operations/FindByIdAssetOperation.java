package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public interface FindByIdAssetOperation extends OperationProcessor<FindByIdAssetOperation.FindByIdAssetResponse, FindByIdAssetOperation.FindByIdAssetRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdAssetResponse implements OperationOutput  {
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
    class FindByIdAssetRequest implements OperationInput {
        private String id;
    }
}
