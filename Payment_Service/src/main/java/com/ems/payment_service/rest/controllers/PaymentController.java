package com.ems.payment_service.rest.controllers;

import com.ems.payment_service.api.operations.salary.SalaryOperation;
import com.ems.payment_service.api.operations.salary.SalaryRequest;
import com.ems.payment_service.api.operations.salary.SalaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Payment service",
        description = "Payment service for providing employees with salaries"
)
@RequiredArgsConstructor
@RestController
@Validated
@RefreshScope
@Slf4j
@RequestMapping(path = "/payment")
public class PaymentController {
    private final SalaryOperation salaryOperation;

//    @Transactional
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Successfully gave a salary to an employee."),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "text/html"))
    })
    @Operation(description = "Provided the employees debit card details will provide him with his deserved salary.",
            summary = "Give salary to an employee.")
    @PostMapping(path = "/salary")
    public ResponseEntity<SalaryResponse> giveSalary(@Valid @RequestBody SalaryRequest request) {
        return new ResponseEntity<>(salaryOperation.process(request), HttpStatus.ACCEPTED);
    }
}
