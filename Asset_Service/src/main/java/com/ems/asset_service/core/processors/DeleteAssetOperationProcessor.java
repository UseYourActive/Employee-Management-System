package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.DeleteAssetOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteAssetOperationProcessor implements DeleteAssetOperation {
    private final AssetRepository assetRepository;

    @Override
    public DeleteAssetResponse process(final DeleteAssetRequest request) {
        log.info("Processing delete asset request: {}", request);

        String id = request.getId();

        log.debug("Attempting to delete asset with ID: {}", id);

        Asset asset = assetRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.error("Asset with ID {} not found for deletion", id);
                    return new AssetNotFoundException();
                });

        assetRepository.delete(asset);

        log.info("Asset with ID {} successfully deleted", id);

        return DeleteAssetResponse.builder()
                .isSuccessfullyDeleted(Boolean.TRUE)
                .build();
    }
}
