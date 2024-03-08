package com.ems.training_and_development_service.api.operations;

import com.ems.training_and_development_service.api.base.OperationInput;
import com.ems.training_and_development_service.api.base.OperationOutput;
import com.ems.training_and_development_service.api.base.OperationProcessor;
import lombok.*;

public interface CreateNewTrainingOperation extends OperationProcessor<CreateNewTrainingOperation.CreateNewTrainingResponse, CreateNewTrainingOperation.CreateNewTrainingRequest> {
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
    class CreateNewTrainingResponse implements OperationOutput {

    }

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
    class CreateNewTrainingRequest implements OperationInput {

    }
}
