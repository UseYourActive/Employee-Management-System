package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.EditAssetOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EditAssetOperationProcessor implements EditAssetOperation {
    private final AssetRepository assetRepository;

    @Override
    public EditAssetResponse process(final EditAssetRequest request) {
        log.info("Processing edit asset request: {}", request);

        String id = request.getId();
        String name = request.getName();
        String description = request.getDescription();
        String serialNumber = request.getSerialNumber();

        Optional<Asset> optionalAsset = assetRepository.findById(UUID.fromString(id));
        Asset asset = optionalAsset.orElseThrow(AssetNotFoundException::new);

        optionalAsset.ifPresent(a -> {
            Optional.ofNullable(description).ifPresent(desc -> {
                log.debug("Updating description for asset with ID {}: {}", id, desc);
                a.setDescription(desc);
            });

            Optional.ofNullable(name).ifPresent(n -> {
                log.debug("Updating name for asset with ID {}: {}", id, n);
                a.setName(n);
            });

            Optional.ofNullable(serialNumber).ifPresent(sn -> {
                log.debug("Updating serial number for asset with ID {}: {}", id, sn);
                a.setSerialNumber(sn);
            });
        });

        Asset persistedAsset = assetRepository.save(asset);

        log.info("Asset updated successfully: {}", persistedAsset.getId());

        return EditAssetResponse.builder()
                .id(String.valueOf(persistedAsset.getId()))
                .description(persistedAsset.getDescription())
                .name(persistedAsset.getName())
                .serialNumber(persistedAsset.getSerialNumber())
                .build();
    }
}

