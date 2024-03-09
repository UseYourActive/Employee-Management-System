package com.ems.training_and_development_service.core.processors;

import com.ems.training_and_development_service.api.operations.DeleteTrainingOperation;
import com.ems.training_and_development_service.core.exceptions.TrainingNotFoundException;
import com.ems.training_and_development_service.persistence.entities.Training;
import com.ems.training_and_development_service.persistence.repositories.TrainingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteTrainingOperationProcessor implements DeleteTrainingOperation {
    private final TrainingRepository trainingRepository;

    @Override
    public DeleteTrainingResponse process(final DeleteTrainingRequest request) {
        String id = request.getId();

        log.info("Processing request to delete training with ID: {}", id);

        Training training = trainingRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.error("Training with ID {} not found for deletion", id);
                    return new TrainingNotFoundException();
                });

        trainingRepository.delete(training);

        log.info("Training with ID {} successfully deleted", id);

        return DeleteTrainingResponse.builder()
                .isSuccessfullyDeleted(Boolean.TRUE)
                .build();
    }
}
