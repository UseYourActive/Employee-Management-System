package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import lombok.*;

public interface EditAssetOperation extends OperationProcessor<EditAssetOperation.EditAssetResponse, EditAssetOperation.EditAssetRequest> {
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
    class EditAssetResponse implements OperationOutput  {

    }

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
    class EditAssetRequest implements OperationInput {

    }
}
