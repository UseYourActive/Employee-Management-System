package com.ems.payment_service.export;

import com.ems.payment_service.api.operations.salary.SalaryRequest;
import com.ems.payment_service.api.operations.salary.SalaryResponse;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentFeignClient {
    @RequestLine("POST /payment/salary")
    SalaryResponse makeCharge(SalaryRequest input);
}
