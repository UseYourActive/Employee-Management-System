package com.ems.asset_service.rest.controllers;

import com.ems.asset_service.api.operations.*;
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
        name = "CRUD REST APIs for Assets",
        description = "CRUD REST API"
)
@RequiredArgsConstructor
@RestController
@Validated
@RefreshScope
@Slf4j
@CrossOrigin
@RequestMapping(path = "/asset")
public class AssetController {
    private final CreateNewAssetOperation createNewAssetOperation;
    private final FindByIdAssetOperation findByIdAssetOperation;
    private final FindAllAssetsOperation findAllAssetsOperation;
    private final DeleteAssetOperation deleteAssetOperation;
    private final EditAssetOperation editAssetOperation;
    private final AssignAssetToEmployeeOperation assignAssetToEmployeeOperation;

    //region GET
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found a asset."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database asset.",
            summary = "Finds a asset by id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<FindByIdAssetOperation.FindByIdAssetResponse> findAssetById(@PathVariable(value = "id") @UUID String input) {
        FindByIdAssetOperation.FindByIdAssetRequest request = FindByIdAssetOperation.FindByIdAssetRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(findByIdAssetOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found all assets."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users finds all assets in the database paginated.",
            summary = "Find all assets.")
    @GetMapping(path = "/find-all")
    public ResponseEntity<FindAllAssetsOperation.FindAllAssetsResponse> findAllAssets(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                                                      @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage) {
        FindAllAssetsOperation.FindAllAssetsRequest request = FindAllAssetsOperation.FindAllAssetsRequest.builder()
                .pageNumber(pageNumber)
                .numberOfAssetsPerPage(numberOfBooksPerPage)
                .build();

        return new ResponseEntity<>(findAllAssetsOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region POST
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create a asset."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request creates a new asset that does not exist in the database yet.",
            summary = "Creates a new asset.")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateNewAssetOperation.CreateNewAssetResponse> createNewAsset(@Valid @RequestBody CreateNewAssetOperation.CreateNewAssetRequest request) {
        return new ResponseEntity<>(createNewAssetOperation.process(request), HttpStatus.CREATED);
    }
    //endregion

    //region PUT
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully edited a asset."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database asset and updates it.",
            summary = "Edits a asset.")
    @PatchMapping(path = "/edit")
    public ResponseEntity<EditAssetOperation.EditAssetResponse> editAsset(@Valid @RequestBody EditAssetOperation.EditAssetRequest request) {
        return new ResponseEntity<>(editAssetOperation.process(request), HttpStatus.OK);
    }

    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully assigned a asset to employee."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request assigns a certain asset stored in the database to a employee.",
            summary = "Assign asset to an employee.")
    @PutMapping(path = "/assign-to-employee")
    public ResponseEntity<AssignAssetToEmployeeOperation.AssignAssetToEmployeeResponse> assignAssetToEmployee(@Valid @RequestBody AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest request) {
        return new ResponseEntity<>(assignAssetToEmployeeOperation.process(request), HttpStatus.OK);
    }
    //endregion

    //region DELETE
    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a asset."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "From the users request finds an already existing in the database asset and deletes it.",
            summary = "Deletes a asset.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DeleteAssetOperation.DeleteAssetResponse> deleteAsset(@PathVariable("id") @UUID String input) {
        DeleteAssetOperation.DeleteAssetRequest request = DeleteAssetOperation.DeleteAssetRequest.builder()
                .id(input)
                .build();

        return new ResponseEntity<>(deleteAssetOperation.process(request), HttpStatus.OK);
    }
    //endregion
}
