package com.ems.asset_service.api.base;

public interface OperationProcessor<Response extends OperationOutput, Request extends OperationInput> {
    Response process(Request request);
}
