package com.ems.training_and_development_service.export;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ems.training_and_development_service.api.operations.CreateNewTrainingOperation.*;
import static com.ems.training_and_development_service.api.operations.DeleteTrainingOperation.*;
import static com.ems.training_and_development_service.api.operations.EditTrainingOperation.*;
import static com.ems.training_and_development_service.api.operations.FindAllTrainingsOperation.*;
import static com.ems.training_and_development_service.api.operations.FindByIdTrainingOperation.*;

@FeignClient(name = "TRAINING-AND-DEVELOPMENT-SERVICE")
public interface TrainingAndDevelopmentFeignClient {
    @GetMapping(path = "/training/{id}")
    ResponseEntity<FindByIdTrainingResponse> findTrainingById(@PathVariable(value = "id") String id);

    @GetMapping(path = "/training/find-all")
    ResponseEntity<FindAllTrainingsResponse> findAllTrainings(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage);

    @PostMapping(path = "/training/create")
    ResponseEntity<CreateNewTrainingResponse> createNewTraining(@RequestBody CreateNewTrainingRequest request);

    @PatchMapping(path = "/training/edit")
    ResponseEntity<EditTrainingResponse> editTraining(@RequestBody EditTrainingRequest request);

    @DeleteMapping(path = "/training/{id}")
    ResponseEntity<DeleteTrainingResponse> deleteTraining(@PathVariable("id") String id);
}
