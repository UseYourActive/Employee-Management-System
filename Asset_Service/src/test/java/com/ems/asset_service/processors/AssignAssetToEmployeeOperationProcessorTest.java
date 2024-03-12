package com.ems.asset_service.processors;

import com.ems.asset_service.api.operations.AssignAssetToEmployeeOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.core.processors.AssignAssetToEmployeeOperationProcessor;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.enums.AssetStatus;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AssignAssetToEmployeeOperationProcessorTest {
    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssignAssetToEmployeeOperationProcessor processor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcess() {
        AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest request = new AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest();
        request.setEmployeeId("bbc28731-40ef-4549-9d14-fb8ce6ce7063");
        request.setAssetId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        Asset asset = new Asset();
        asset.setId(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.of(asset));
        when(assetRepository.save(any(Asset.class))).thenReturn(asset);

        AssignAssetToEmployeeOperation.AssignAssetToEmployeeResponse response = processor.process(request);

        assertEquals("0c12f641-1e26-449c-9b16-80d1e3a7837c", response.getId());
        assertEquals("bbc28731-40ef-4549-9d14-fb8ce6ce7063", response.getEmployeeId());

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, times(1)).save(any(Asset.class));
    }

    @Test
    void testProcess_SuccessfullyAssigned() {
        AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest request = new AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest();
        request.setEmployeeId("bbc28731-40ef-4549-9d14-fb8ce6ce7063");
        request.setAssetId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        Asset asset = new Asset();
        asset.setId(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.of(asset));
        when(assetRepository.save(any(Asset.class))).thenReturn(asset);

        AssignAssetToEmployeeOperation.AssignAssetToEmployeeResponse response = processor.process(request);

        assertNotNull(response);
        assertEquals("0c12f641-1e26-449c-9b16-80d1e3a7837c", response.getId());
        assertEquals("bbc28731-40ef-4549-9d14-fb8ce6ce7063", response.getEmployeeId());
        assertEquals(AssetStatus.ASSIGNED.toString(), response.getAssetStatus());

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, times(1)).save(any(Asset.class));
    }

    @Test
    void testProcess_AssetNotFound() {
        AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest request = new AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest();
        request.setEmployeeId("bbc28731-40ef-4549-9d14-fb8ce6ce7063");
        request.setAssetId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.empty());

        assertThrows(AssetNotFoundException.class, () -> processor.process(request));

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, never()).save(any(Asset.class));
    }

    @Test
    void testProcess_NullEmployeeIdOrAssetId() {
        AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest request = new AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest();
        request.setEmployeeId(null);
        request.setAssetId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        assertThrows(AssetNotFoundException.class, () -> processor.process(request));

        request.setEmployeeId("bbc28731-40ef-4549-9d14-fb8ce6ce7063");
        request.setAssetId(null);

        assertThrows(NullPointerException.class, () -> processor.process(request));
    }

    @Test
    void testProcess_ReassignAsset() {
        AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest request = new AssignAssetToEmployeeOperation.AssignAssetToEmployeeRequest();
        request.setEmployeeId("bbc28731-40ef-4549-9d14-fb8ce6ce7063");
        request.setAssetId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        Asset asset = new Asset();
        asset.setId(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        asset.setEmployeeId(UUID.fromString("2eba2f96-5692-46b0-b7a1-e782d0e89300"));
        asset.setAssetStatus(AssetStatus.ASSIGNED);

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.of(asset));
        when(assetRepository.save(any(Asset.class))).thenReturn(asset);

        AssignAssetToEmployeeOperation.AssignAssetToEmployeeResponse response = processor.process(request);

        assertNotNull(response);
        assertEquals("0c12f641-1e26-449c-9b16-80d1e3a7837c", response.getId());
        assertEquals("bbc28731-40ef-4549-9d14-fb8ce6ce7063", response.getEmployeeId());
        assertEquals(AssetStatus.ASSIGNED.toString(), response.getAssetStatus());

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, times(1)).save(any(Asset.class));
    }
}
