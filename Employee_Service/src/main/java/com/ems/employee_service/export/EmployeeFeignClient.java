package com.ems.employee_service.export;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeFeignClient {
}
