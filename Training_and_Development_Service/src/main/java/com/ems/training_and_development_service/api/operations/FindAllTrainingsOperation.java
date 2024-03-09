package com.ems.training_and_development_service.api.operations;

import com.ems.training_and_development_service.api.base.OperationInput;
import com.ems.training_and_development_service.api.base.OperationOutput;
import com.ems.training_and_development_service.api.base.OperationProcessor;
import lombok.*;

import java.util.List;

public interface FindAllTrainingsOperation extends OperationProcessor<FindAllTrainingsOperation.FindAllTrainingsResponse, FindAllTrainingsOperation.FindAllTrainingsRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllTrainingsResponse implements OperationOutput {
        private List<FindAllTrainingsResponseDTO> findAllTrainingsResponseDTOS;
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

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllTrainingsResponseDTO {
        private String id;
        private String title;
        private String description;
        private String startDate;
        private String endDate;
    }
}
