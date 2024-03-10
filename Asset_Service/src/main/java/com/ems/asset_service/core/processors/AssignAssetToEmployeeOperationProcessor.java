package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.AssignAssetToEmployeeOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.enums.AssetStatus;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssignAssetToEmployeeOperationProcessor implements AssignAssetToEmployeeOperation {
    private final AssetRepository assetRepository;

    @Override
    public AssignAssetToEmployeeResponse process(final AssignAssetToEmployeeRequest request) {
        String employeeId = request.getEmployeeId();
        String assetId = request.getAssetId();

        Asset asset = assetRepository.findById(UUID.fromString(assetId))
                .orElseThrow(AssetNotFoundException::new);

        asset.setEmployeeId(UUID.fromString(employeeId));
        asset.setAssetStatus(AssetStatus.ASSIGNED);

        Asset persistedAsset = assetRepository.save(asset);

        return AssignAssetToEmployeeResponse.builder()
                .id(String.valueOf(persistedAsset.getId()))
                .employeeId(String.valueOf(persistedAsset.getEmployeeId()))
                .description(persistedAsset.getDescription())
                .assetType(String.valueOf(persistedAsset.getAssetType()))
                .assetStatus(String.valueOf(persistedAsset.getAssetStatus()))
                .name(persistedAsset.getName())
                .serialNumber(persistedAsset.getSerialNumber())
                .build();
    }
}
