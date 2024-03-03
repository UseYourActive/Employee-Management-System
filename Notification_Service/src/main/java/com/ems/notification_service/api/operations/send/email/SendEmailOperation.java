package com.ems.notification_service.api.operations.send.email;

import com.ems.notification_service.api.base.OperationInput;
import com.ems.notification_service.api.base.OperationOutput;
import com.ems.notification_service.api.base.OperationProcessor;
import lombok.*;

public interface SendEmailOperation
        extends OperationProcessor<SendEmailOperation.SendEmailOperationResponse, SendEmailOperation.SendEmailOperationRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class SendEmailOperationRequest implements OperationInput {
        private String to;
        private String subject;
        private String text;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class SendEmailOperationResponse implements OperationOutput {
        private Boolean isSentSuccessfully;
    }
}
