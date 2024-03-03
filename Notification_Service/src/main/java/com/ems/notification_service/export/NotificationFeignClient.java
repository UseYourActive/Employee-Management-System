package com.ems.notification_service.export;

import com.ems.notification_service.api.operations.send.email.SendEmailOperation;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "NOTIFICATION-SERVICE")
public interface NotificationFeignClient {
    @RequestLine("POST /email/send")
    SendEmailOperation.SendEmailOperationResponse sendEmail(SendEmailOperation.SendEmailOperationRequest request);
}
