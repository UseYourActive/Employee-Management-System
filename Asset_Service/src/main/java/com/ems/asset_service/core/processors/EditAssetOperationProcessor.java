package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.EditAssetOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EditAssetOperationProcessor implements EditAssetOperation {
    @Override
    public EditAssetResponse process(final EditAssetRequest request) {
        return null;
    }
}
