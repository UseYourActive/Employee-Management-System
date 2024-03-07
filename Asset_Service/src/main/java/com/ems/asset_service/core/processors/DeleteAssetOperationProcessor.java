package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.DeleteAssetOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteAssetOperationProcessor implements DeleteAssetOperation {
    @Override
    public DeleteAssetResponse process(final DeleteAssetRequest request) {
        return null;
    }
}
