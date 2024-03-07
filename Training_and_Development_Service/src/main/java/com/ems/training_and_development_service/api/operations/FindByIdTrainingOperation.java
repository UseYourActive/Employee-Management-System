package com.ems.training_and_development_service.api.operations;

import com.ems.training_and_development_service.api.base.OperationInput;
import com.ems.training_and_development_service.api.base.OperationOutput;
import com.ems.training_and_development_service.api.base.OperationProcessor;
import lombok.*;

public interface FindByIdTrainingOperation extends OperationProcessor<FindByIdTrainingOperation.FindByIdTrainingResponse, FindByIdTrainingOperation.FindByIdTrainingRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdTrainingResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdTrainingRequest implements OperationInput {
        private String id;
    }
}
