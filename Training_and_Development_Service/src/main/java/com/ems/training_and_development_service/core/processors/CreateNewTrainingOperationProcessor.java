package com.ems.training_and_development_service.core.processors;

import com.ems.training_and_development_service.api.operations.CreateNewTrainingOperation;
import com.ems.training_and_development_service.persistence.entities.Training;
import com.ems.training_and_development_service.persistence.repositories.TrainingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateNewTrainingOperationProcessor implements CreateNewTrainingOperation {
    private final TrainingRepository trainingRepository;

    @Override
    public CreateNewTrainingResponse process(final CreateNewTrainingRequest request) {
        String description = request.getDescription();
        String title = request.getTitle();
        String endDate = request.getEndDate();
        String startDate = request.getStartDate();

        log.info("Creating new training with title: {}, start date: {}, end date: {}, and description: {}",
                title, startDate, endDate, description);

        Training training = Training.builder()
                .description(description)
                .title(title)
                .endDate(LocalDate.parse(endDate))
                .startDate(LocalDate.parse(startDate))
                .build();

        Training persistedTraining = trainingRepository.save(training);

        log.info("New training created with ID: {}", persistedTraining.getId());

        return CreateNewTrainingResponse.builder()
                .id(String.valueOf(persistedTraining.getId()))
                .description(persistedTraining.getDescription())
                .title(persistedTraining.getTitle())
                .startDate(String.valueOf(persistedTraining.getStartDate()))
                .endDate(String.valueOf(persistedTraining.getEndDate()))
                .build();
    }
}
