package com.ems.attendance_service.rest.controllers;

import com.ems.attendance_service.api.operations.*;
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
        name = "CRUD REST APIs for Attendance",
        description = "CRUD REST API"
)
@RequiredArgsConstructor
@RestController
@Validated
@RefreshScope
@Slf4j
@CrossOrigin
@RequestMapping(path = "/attendance")
public class AttendanceController {
    private final CreateNewAttendanceOperation createNewAttendanceOperation;
    private final FindByIdAttendanceOperation findByIdAttendanceOperation;
    private final FindAllAttendancesOperation findAllAttendancesOperation;
    private final DeleteAttendanceOperation deleteAttendanceOperation;
    private final EditAttendanceOperation editAttendanceOperation;

    //region GET
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found a attendance."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database attendance.",
            summary = "Finds a employee by id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FindByIdAttendanceOperation.FindByIdAttendanceResponse> findAttendanceById(@PathVariable(value = "id") @UUID String input) {
        FindByIdAttendanceOperation.FindByIdAttendanceRequest request = FindByIdAttendanceOperation.FindByIdAttendanceRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(findByIdAttendanceOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found all attendances."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users finds all attendances in the database paginated.",
            summary = "Find all attendances.")
    @GetMapping(path = "/find-all")
    public ResponseEntity<FindAllAttendancesOperation.FindAllAttendancesResponse> findAllAttendances(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                                                                     @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage) {
        FindAllAttendancesOperation.FindAllAttendancesRequest request = FindAllAttendancesOperation.FindAllAttendancesRequest.builder()
                .pageNumber(pageNumber)
                .numberOfBooksPerPage(numberOfBooksPerPage)
                .build();

        return new ResponseEntity<>(findAllAttendancesOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region POST
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create a attendance."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request creates a new attendance that does not exist in the database yet.",
            summary = "Creates a new attendance.")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateNewAttendanceOperation.CreateNewAttendanceResponse> createNewAttendance(@Valid @RequestBody CreateNewAttendanceOperation.CreateNewAttendanceRequest request) {
        return new ResponseEntity<>(createNewAttendanceOperation.process(request), HttpStatus.CREATED);
    }
    //endregion

    //region PUT
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully edited a employee."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database attendance and updates it.",
            summary = "Edits a attendance.")
    @PatchMapping(path = "/edit")
    public ResponseEntity<EditAttendanceOperation.EditAttendanceResponse> editAttendance(@Valid @RequestBody EditAttendanceOperation.EditAttendanceRequest request) {
        return new ResponseEntity<>(editAttendanceOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region DELETE
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a employee."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database attendance and deletes it.",
            summary = "Deletes a attendance.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeleteAttendanceOperation.DeleteAttendanceResponse> deleteAttendance(@PathVariable("id") @UUID String input) {
        DeleteAttendanceOperation.DeleteAttendanceRequest request = DeleteAttendanceOperation.DeleteAttendanceRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(deleteAttendanceOperation.process(request), HttpStatus.OK);
    }
    //endregion
}
