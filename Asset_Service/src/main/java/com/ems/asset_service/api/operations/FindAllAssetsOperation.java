package com.ems.asset_service.api.operations;

import com.ems.asset_service.api.base.OperationInput;
import com.ems.asset_service.api.base.OperationOutput;
import com.ems.asset_service.api.base.OperationProcessor;
import lombok.*;

import java.util.List;

public interface FindAllAssetsOperation extends OperationProcessor<FindAllAssetsOperation.FindAllAssetsResponse, FindAllAssetsOperation.FindAllAssetsRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllAssetsResponse implements OperationOutput  {
        private List<FindAllAssetsResponseDTO> findAllAssetsResponseDTOS;
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

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllAssetsResponseDTO {
        private String id;
        private String name;
        private String description;
        private String serialNumber;
    }
}
