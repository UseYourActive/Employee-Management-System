package com.ems.training_and_development_service.api.operations;

import com.ems.training_and_development_service.api.base.OperationInput;
import com.ems.training_and_development_service.api.base.OperationOutput;
import com.ems.training_and_development_service.api.base.OperationProcessor;
import lombok.*;

public interface FindAllTrainingsOperation extends OperationProcessor<FindAllTrainingsOperation.FindAllTrainingsResponse, FindAllTrainingsOperation.FindAllTrainingsRequest> {
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
    class FindAllTrainingsResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllTrainingsRequest implements OperationInput {
        private Integer pageNumber;
        private Integer numberOfBooksPerPage;
    }
}
