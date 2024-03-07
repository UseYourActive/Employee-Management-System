package com.ems.training_and_development_service.core.processors;

import com.ems.training_and_development_service.api.operations.CreateNewTrainingOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateNewTrainingOperationProcessor implements CreateNewTrainingOperation {
    @Override
    public CreateNewTrainingResponse process(final CreateNewTrainingRequest request) {
        return null;
    }
}
