package com.ems.department_service.export;

import com.ems.department_service.api.operations.create.CreateNewDepartmentRequest;
import com.ems.department_service.api.operations.create.CreateNewDepartmentResponse;
import com.ems.department_service.api.operations.delete.DeleteDepartmentResponse;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentRequest;
import com.ems.department_service.api.operations.edit.full.EditFullDepartmentResponse;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsResponse;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentResponse;
import feign.Headers;
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

//    @Headers("Content-Type: application/json")
    @RequestLine("POST /departments/create")
    CreateNewDepartmentResponse createNewDepartment(CreateNewDepartmentRequest request);

//    @Headers("Content-Type: application/json")
    @RequestLine("PATCH /departments/edit")
    EditFullDepartmentResponse editDepartment(EditFullDepartmentRequest request);

    @RequestLine("DELETE /departments/{id}")
    DeleteDepartmentResponse deleteDepartment(@Param("id") String id);
}
