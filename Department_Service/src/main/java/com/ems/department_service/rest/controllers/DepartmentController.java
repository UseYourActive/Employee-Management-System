package com.ems.department_service.rest.controllers;

import com.ems.department_service.api.operations.create.CreateNewDepartmentOperation;
import com.ems.department_service.api.operations.create.CreateNewDepartmentRequest;
import com.ems.department_service.api.operations.create.CreateNewDepartmentResponse;
import com.ems.department_service.api.operations.delete.DeleteDepartmentOperation;
import com.ems.department_service.api.operations.delete.DeleteDepartmentRequest;
import com.ems.department_service.api.operations.delete.DeleteDepartmentResponse;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentOperation;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentRequest;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentResponse;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsOperation;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsRequest;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsResponse;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentOperation;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentRequest;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentResponse;
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
        name = "CRUD REST APIs for Department Resource",
        description = "CRUD REST APIs - Create department, Update department, Find department, Find all department, Delete department"
)
@RequiredArgsConstructor
@RestController
@Validated
@RefreshScope
@Slf4j
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final CreateNewDepartmentOperation createNewDepartmentOperation;
    private final FindByIdDepartmentOperation findByIdDepartmentOperation;
    private final FindAllDepartmentsOperation findAllDepartmentsOperation;
    private final DeleteDepartmentOperation deleteDepartmentOperation;
    private final EditFullDepartmentOperation editFullDepartmentOperation;
    //region GET
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found a department."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database department.",
            summary = "Finds a department by id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FindByIdDepartmentResponse> findDepartmentById(@PathVariable(value = "id") @UUID String input) {
        FindByIdDepartmentRequest request = FindByIdDepartmentRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(findByIdDepartmentOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found all departments."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users finds all departments in the database paginated.",
            summary = "Find all departments.")
    @GetMapping(path = "/find-all")
    public ResponseEntity<FindAllDepartmentsResponse> findAllDepartments(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                                       @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage) {
        FindAllDepartmentsRequest request = FindAllDepartmentsRequest.builder()
                .pageNumber(pageNumber)
                .numberOfBooksPerPage(numberOfBooksPerPage)
                .build();

        return new ResponseEntity<>(findAllDepartmentsOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region POST
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create a department."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request creates a new department that does not exist in the database yet.",
            summary = "Creates a new department.")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateNewDepartmentResponse> createNewDepartment(@Valid @RequestBody CreateNewDepartmentRequest request) {
        return new ResponseEntity<>(createNewDepartmentOperation.process(request), HttpStatus.CREATED);
    }
    //endregion

    //region PUT
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully edited a department."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database department and updates it.",
            summary = "Edits a department.")
    @PatchMapping(path = "/edit")
    public ResponseEntity<EditFullDepartmentResponse> editDepartment(@Valid @RequestBody EditFullDepartmentRequest request) {
        return new ResponseEntity<>(editFullDepartmentOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region DELETE
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a department."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database department and deletes it.",
            summary = "Deletes a department.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeleteDepartmentResponse> deleteDepartment(@PathVariable("id") @UUID String input) {
        DeleteDepartmentRequest request = DeleteDepartmentRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(deleteDepartmentOperation.process(request), HttpStatus.OK);
    }
    //endregion
}
