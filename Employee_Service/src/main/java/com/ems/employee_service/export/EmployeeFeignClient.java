package com.ems.employee_service.export;

import com.ems.employee_service.api.operations.create.CreateNewEmployeeRequest;
import com.ems.employee_service.api.operations.create.CreateNewEmployeeResponse;
import com.ems.employee_service.api.operations.delete.DeleteEmployeeResponse;
import com.ems.employee_service.api.operations.edit.EditEmployeeRequest;
import com.ems.employee_service.api.operations.edit.EditEmployeeResponse;
import com.ems.employee_service.api.operations.find.all.FindAllEmployeesResponse;
import com.ems.employee_service.api.operations.find.byid.FindByIdEmployeeResponse;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeFeignClient {
    @GetMapping("/employees/{id}")
    ResponseEntity<FindByIdEmployeeResponse> findEmployeeById(@PathVariable(value = "id") @UUID String input);

    @GetMapping("/employees/find-all")
    ResponseEntity<FindAllEmployeesResponse> findAllEmployees(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage);

    @PostMapping("/employees/create")
    ResponseEntity<CreateNewEmployeeResponse> createNewEmployee(@Valid @RequestBody CreateNewEmployeeRequest request);

    @PatchMapping("/employees/edit")
    ResponseEntity<EditEmployeeResponse> editEmployee(@Valid @RequestBody EditEmployeeRequest request);

    @DeleteMapping("/employees/{id}")
    ResponseEntity<DeleteEmployeeResponse> deleteEmployee(@PathVariable("id") @UUID String input);
}

//@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultService") -> on the controller methods
//@LoadBalanced
