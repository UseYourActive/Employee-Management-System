package com.ems.department_service.export;

import com.ems.department_service.api.operations.create.CreateNewDepartmentRequest;
import com.ems.department_service.api.operations.create.CreateNewDepartmentResponse;
import com.ems.department_service.api.operations.delete.DeleteDepartmentResponse;
import com.ems.department_service.api.operations.edit.budget.EditDepartmentBudgetRequest;
import com.ems.department_service.api.operations.edit.budget.EditDepartmentBudgetResponse;
import com.ems.department_service.api.operations.edit.description.EditDepartmentDescriptionRequest;
import com.ems.department_service.api.operations.edit.description.EditDepartmentDescriptionResponse;
import com.ems.department_service.api.operations.edit.email.EditDepartmentEmailRequest;
import com.ems.department_service.api.operations.edit.email.EditDepartmentEmailResponse;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentRequest;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentResponse;
import com.ems.department_service.api.operations.edit.location.EditDepartmentLocationRequest;
import com.ems.department_service.api.operations.edit.location.EditDepartmentLocationResponse;
import com.ems.department_service.api.operations.edit.name.EditDepartmentNameRequest;
import com.ems.department_service.api.operations.edit.name.EditDepartmentNameResponse;
import com.ems.department_service.api.operations.edit.phone_number.EditDepartmentPhoneNumberRequest;
import com.ems.department_service.api.operations.edit.phone_number.EditDepartmentPhoneNumberResponse;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsResponse;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentResponse;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentFeignClient {
    @RequestLine("GET /departments/{id}")
    FindByIdDepartmentResponse findDepartmentById(@Param("id") String id);

    @RequestLine("GET /departments/find-all?pageNumber={pageNumber}&numberOfBooksPerPage={numberOfBooksPerPage}")
    FindAllDepartmentsResponse findAllDepartments(@Param("pageNumber") Integer pageNumber,
                                                  @Param("numberOfBooksPerPage") Integer numberOfBooksPerPage);

    @RequestLine("POST /departments/create")
    CreateNewDepartmentResponse createNewDepartment(CreateNewDepartmentRequest request);

    @RequestLine("PUT /departments/edit-full")
    EditFullDepartmentResponse editFullDepartment(EditFullDepartmentRequest request);

    @RequestLine("PATCH /departments/edit-name")
    EditDepartmentNameResponse editDepartmentName(EditDepartmentNameRequest request);

    @RequestLine("PATCH /departments/edit-description")
    EditDepartmentDescriptionResponse editDepartmentDescription(EditDepartmentDescriptionRequest request);

    @RequestLine("PATCH /departments/edit-email")
    EditDepartmentEmailResponse editDepartmentEmail(EditDepartmentEmailRequest request);

    @RequestLine("PATCH /departments/edit-location")
    EditDepartmentLocationResponse editDepartmentLocation(EditDepartmentLocationRequest request);

    @RequestLine("PATCH /departments/edit-phone-number")
    EditDepartmentPhoneNumberResponse editDepartmentPhoneNumber(EditDepartmentPhoneNumberRequest request);

    @RequestLine("PATCH /departments/edit-budget")
    EditDepartmentBudgetResponse editDepartmentBudget(EditDepartmentBudgetRequest request);

    @RequestLine("DELETE /departments/{id}")
    DeleteDepartmentResponse deleteDepartment(@Param("id") String id);
}
