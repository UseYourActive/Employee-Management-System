package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.FindAllAssetsOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindAllAssetsOperationProcessor implements FindAllAssetsOperation {
    @Override
    public FindAllAssetsResponse process(final FindAllAssetsRequest request) {
        return null;
    }
}
