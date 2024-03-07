package com.ems.training_and_development_service.core.processors;

import com.ems.training_and_development_service.api.operations.DeleteTrainingOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteTrainingOperationProcessor implements DeleteTrainingOperation {
    @Override
    public DeleteTrainingResponse process(final DeleteTrainingRequest request) {
        return null;
    }
}
