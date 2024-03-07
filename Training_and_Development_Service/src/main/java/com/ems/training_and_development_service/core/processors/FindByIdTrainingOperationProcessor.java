package com.ems.training_and_development_service.core.processors;

import com.ems.training_and_development_service.api.operations.FindByIdTrainingOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindByIdTrainingOperationProcessor implements FindByIdTrainingOperation {
    @Override
    public FindByIdTrainingResponse process(final FindByIdTrainingRequest request) {
        return null;
    }
}
