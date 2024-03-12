package com.ems.asset_service.processors;

import com.ems.asset_service.api.operations.DeleteAssetOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.core.processors.DeleteAssetOperationProcessor;
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

class DeleteAssetOperationProcessorTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private DeleteAssetOperationProcessor processor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcess_SuccessfullyDeleted() {
        DeleteAssetOperation.DeleteAssetRequest request = new DeleteAssetOperation.DeleteAssetRequest();
        request.setId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        Asset asset = new Asset();
        asset.setId(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.of(asset));

        DeleteAssetOperation.DeleteAssetResponse response = processor.process(request);

        assertNotNull(response);
        assertTrue(response.getIsSuccessfullyDeleted());

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, times(1)).delete(asset);
    }

    @Test
    void testProcess_AssetNotFound() {
        DeleteAssetOperation.DeleteAssetRequest request = new DeleteAssetOperation.DeleteAssetRequest();
        request.setId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.empty());

        assertThrows(AssetNotFoundException.class, () -> processor.process(request));

        verify(assetRepository, times(1)).findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));
        verify(assetRepository, never()).delete(any(Asset.class));
    }

    @Test
    void testProcess_NullAssetId() {
        DeleteAssetOperation.DeleteAssetRequest request = new DeleteAssetOperation.DeleteAssetRequest();
        request.setId(null);

        assertThrows(NullPointerException.class, () -> processor.process(request));

        verify(assetRepository, never()).findById(any(UUID.class));
        verify(assetRepository, never()).delete(any(Asset.class));
    }

    @Test
    void testProcess_InvalidAssetIdFormat() {
        DeleteAssetOperation.DeleteAssetRequest request = new DeleteAssetOperation.DeleteAssetRequest();
        request.setId("invalid_uuid");

        assertThrows(IllegalArgumentException.class, () -> processor.process(request));

        verify(assetRepository, never()).findById(any(UUID.class));
        verify(assetRepository, never()).delete(any(Asset.class));
    }

    @Test
    void testProcess_DeleteAssetOnce() {
        DeleteAssetOperation.DeleteAssetRequest request = new DeleteAssetOperation.DeleteAssetRequest();
        request.setId("0c12f641-1e26-449c-9b16-80d1e3a7837c");

        Asset asset = new Asset();
        asset.setId(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"));

        when(assetRepository.findById(UUID.fromString("0c12f641-1e26-449c-9b16-80d1e3a7837c"))).thenReturn(Optional.of(asset));

        processor.process(request);
        processor.process(request);

        verify(assetRepository, atLeastOnce()).delete(asset);
    }
}

