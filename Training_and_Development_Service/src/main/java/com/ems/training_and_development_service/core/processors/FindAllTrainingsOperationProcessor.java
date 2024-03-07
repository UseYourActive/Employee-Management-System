package com.ems.training_and_development_service.core.processors;

import com.ems.training_and_development_service.api.operations.FindAllTrainingsOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindAllTrainingsOperationProcessor implements FindAllTrainingsOperation {
    @Override
    public FindAllTrainingsResponse process(final FindAllTrainingsRequest request) {
        return null;
    }
}
