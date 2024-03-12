package com.ems.asset_service.processors;

import com.ems.asset_service.api.operations.EditAssetOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.core.processors.EditAssetOperationProcessor;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditAssetOperationProcessorTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private EditAssetOperationProcessor processor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcess_SuccessfullyEdited() {
        EditAssetOperation.EditAssetRequest request = new EditAssetOperation.EditAssetRequest();
        request.setId("0c12f641-1e26-449c-9b16-80d1e3a7837c");
        request.setName("New Laptop");
        request.setDescription("Updated laptop description");
        request.setSerialNumber("123456789");
        request.setAssetStatus("ASSIGNED");
        request.setAssetType("COMPUTER");

        Asset existingAsset = new Asset();
        existingAsset.setId(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.of(existingAsset));
        when(assetRepository.save(any(Asset.class))).thenReturn(existingAsset);

        EditAssetOperation.EditAssetResponse response = processor.process(request);

        assertNotNull(response);
        assertEquals("0c12f641-1e26-449c-9b16-80d1e3a7837c", response.getId());
        assertEquals("New Laptop", response.getName());
        assertEquals("Updated laptop description", response.getDescription());
        assertEquals("123456789", response.getSerialNumber());
        assertEquals("ASSIGNED", response.getAssetStatus());
        assertEquals("COMPUTER", response.getAssetType());

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, times(1)).save(any(Asset.class));
    }

    @Test
    void testProcess_InvalidAssetId() {
        EditAssetOperation.EditAssetRequest request = new EditAssetOperation.EditAssetRequest();
        request.setId("invalid_uuid");

        assertThrows(IllegalArgumentException.class, () -> processor.process(request));

        verify(assetRepository, never()).findById(any(UUID.class));
        verify(assetRepository, never()).save(any(Asset.class));
    }

    @Test
    void testProcess_AssetNotFound() {
        EditAssetOperation.EditAssetRequest request = new EditAssetOperation.EditAssetRequest();
        request.setId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.empty());

        assertThrows(AssetNotFoundException.class, () -> processor.process(request));

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, never()).save(any(Asset.class));
    }
}

