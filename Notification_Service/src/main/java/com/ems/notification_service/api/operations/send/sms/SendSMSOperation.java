package com.ems.notification_service.api.operations.send.sms;

import com.ems.notification_service.api.base.OperationInput;
import com.ems.notification_service.api.base.OperationOutput;
import com.ems.notification_service.api.base.OperationProcessor;
import lombok.*;

public interface SendSMSOperation
        extends OperationProcessor<SendSMSOperation.SendSMSOperationResponse, SendSMSOperation.SendSMSOperationRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class SendSMSOperationRequest implements OperationInput {
        private String toPhoneNumber;
        private String fromPhoneNumber;
        private String message;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class SendSMSOperationResponse implements OperationOutput {
        private Boolean isSentSuccessfully;
    }
}
