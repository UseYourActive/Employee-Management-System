package com.ems.training_and_development_service.api.operations;

import com.ems.training_and_development_service.api.base.OperationInput;
import com.ems.training_and_development_service.api.base.OperationOutput;
import com.ems.training_and_development_service.api.base.OperationProcessor;
import lombok.*;

public interface DeleteTrainingOperation extends OperationProcessor<DeleteTrainingOperation.DeleteTrainingResponse, DeleteTrainingOperation.DeleteTrainingRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class DeleteTrainingResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class DeleteTrainingRequest implements OperationInput {
        private String id;
    }
}
