package com.ems.training_and_development_service.api.operations;

import com.ems.training_and_development_service.api.base.OperationInput;
import com.ems.training_and_development_service.api.base.OperationOutput;
import com.ems.training_and_development_service.api.base.OperationProcessor;
import lombok.*;

public interface EditTrainingOperation extends OperationProcessor<EditTrainingOperation.EditTrainingResponse, EditTrainingOperation.EditTrainingRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditTrainingResponse implements OperationOutput {
        private String id;
        private String title;
        private String description;
        private String startDate;
        private String endDate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditTrainingRequest implements OperationInput {
        private String id;
        private String title;
        private String description;
        private String startDate;
        private String endDate;
    }
}
