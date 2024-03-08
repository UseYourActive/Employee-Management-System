package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import lombok.*;

public interface FindAllAssetsOperation extends OperationProcessor<FindAllAssetsOperation.FindAllAssetsResponse, FindAllAssetsOperation.FindAllAssetsRequest> {
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
    class FindAllAssetsResponse implements OperationOutput  {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllAssetsRequest implements OperationInput {
        private Integer pageNumber;
        private Integer numberOfBooksPerPage;
    }
}
