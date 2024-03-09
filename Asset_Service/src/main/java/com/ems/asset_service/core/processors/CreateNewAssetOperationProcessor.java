package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.CreateNewAssetOperation;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateNewAssetOperationProcessor implements CreateNewAssetOperation {
    private final AssetRepository assetRepository;

    @Override
    public CreateNewAssetResponse process(final CreateNewAssetRequest request) {
        log.info("Processing create new asset request: {}", request);

        String name = request.getName();
        String description = request.getDescription();
        String serialNumber = request.getSerialNumber();

        log.debug("Creating asset with name: {}, description: {}, serial number: {}", name, description, serialNumber);

        Asset asset = Asset.builder()
                .description(description)
                .serialNumber(serialNumber)
                .name(name)
                .build();

        Asset persistedAsset = assetRepository.save(asset);

        log.info("Asset created successfully with ID: {}", persistedAsset.getId());

        return CreateNewAssetResponse.builder()
                .id(String.valueOf(persistedAsset.getId()))
                .name(persistedAsset.getName())
                .serialNumber(persistedAsset.getSerialNumber())
                .description(persistedAsset.getDescription())
                .build();
    }
}
