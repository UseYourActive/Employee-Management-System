package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.FindByIdAssetOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByIdAssetOperationProcessor implements FindByIdAssetOperation {
    @Override
    public FindByIdAssetResponse process(final FindByIdAssetRequest request) {
        return null;
    }
}
