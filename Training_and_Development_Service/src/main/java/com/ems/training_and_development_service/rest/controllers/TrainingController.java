package com.ems.training_and_development_service.rest.controllers;

import com.ems.training_and_development_service.api.operations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UUID;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Training and Development",
        description = "CRUD REST API"
)
@RequiredArgsConstructor
@RestController
@Validated
@RefreshScope
@Slf4j
@CrossOrigin
@RequestMapping(path = "/training")
public class TrainingController {
    private final CreateNewTrainingOperation createNewTrainingOperation;
    private final FindByIdTrainingOperation findByIdTrainingOperation;
    private final FindAllTrainingsOperation findAllTrainingsOperation;
    private final DeleteTrainingOperation deleteTrainingOperation;
    private final EditTrainingOperation editTrainingOperation;


    //region GET
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found a training."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database training.",
            summary = "Finds a training by id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FindByIdTrainingOperation.FindByIdTrainingResponse> findTrainingById(@PathVariable(value = "id") @UUID String input) {
        FindByIdTrainingOperation.FindByIdTrainingRequest request = FindByIdTrainingOperation.FindByIdTrainingRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(findByIdTrainingOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found all trainings."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users finds all trainings in the database paginated.",
            summary = "Find all trainings.")
    @GetMapping(path = "/find-all")
    public ResponseEntity<FindAllTrainingsOperation.FindAllTrainingsResponse> findAllTrainings(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                                                               @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage) {
        FindAllTrainingsOperation.FindAllTrainingsRequest request = FindAllTrainingsOperation.FindAllTrainingsRequest.builder()
                .pageNumber(pageNumber)
                .numberOfBooksPerPage(numberOfBooksPerPage)
                .build();

        return new ResponseEntity<>(findAllTrainingsOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region POST
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create a training."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request creates a new training that does not exist in the database yet.",
            summary = "Creates a new training.")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateNewTrainingOperation.CreateNewTrainingResponse> createNewTraining(@Valid @RequestBody CreateNewTrainingOperation.CreateNewTrainingRequest request) {
        return new ResponseEntity<>(createNewTrainingOperation.process(request), HttpStatus.CREATED);
    }
    //endregion

    //region PUT
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully edited a training."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database training and updates it.",
            summary = "Edits a training.")
    @PatchMapping(path = "/edit")
    public ResponseEntity<EditTrainingOperation.EditTrainingResponse> editTraining(@Valid @RequestBody EditTrainingOperation.EditTrainingRequest request) {
        return new ResponseEntity<>(editTrainingOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region DELETE
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a training."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database training and deletes it.",
            summary = "Deletes a training.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeleteTrainingOperation.DeleteTrainingResponse> deleteTraining(@PathVariable("id") @UUID String input) {
        DeleteTrainingOperation.DeleteTrainingRequest request = DeleteTrainingOperation.DeleteTrainingRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(deleteTrainingOperation.process(request), HttpStatus.OK);
    }
    //endregion
}
