package com.ems.employee_service.export;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeFeignClient {
}

//@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultService") -> on the controller methods
//@LoadBalanced

// use in different microservices