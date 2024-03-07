package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.CreateNewAssetOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateNewAssetOperationProcessor implements CreateNewAssetOperation {
    @Override
    public CreateNewAssetResponse process(final CreateNewAssetRequest request) {
        return null;
    }
}
