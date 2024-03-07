package com.ems.leave_service.export;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "LEAVE-SERVICE")
public interface LeaveFeignClient {
}
