package com.ems.asset_service.processors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ems.asset_service.api.operations.FindByIdAssetOperation;
import com.ems.asset_service.core.exceptions.AssetNotFoundException;
import com.ems.asset_service.core.processors.FindByIdAssetOperationProcessor;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.enums.AssetStatus;
import com.ems.asset_service.persistence.enums.AssetType;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

public class FindByIdAssetOperationProcessorTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private FindByIdAssetOperationProcessor processor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcess_Successful() {
        UUID id = UUID.fromString("e412c10b-568a-4410-9e3f-31048f37236f");
        Asset asset = Asset.builder()
                .id(id)
                .name("Asset 1")
                .employeeId(UUID.fromString("85436761-d536-4ca5-9867-6956b22dcf19"))
                .assetStatus(AssetStatus.AVAILABLE)
                .assetType(AssetType.TV)
                .serialNumber("SN1")
                .description("Description 1")
                .build();
        FindByIdAssetOperation.FindByIdAssetRequest request = new FindByIdAssetOperation.FindByIdAssetRequest(id.toString());
        when(assetRepository.findById(id)).thenReturn(Optional.of(asset));

        FindByIdAssetOperation.FindByIdAssetResponse response = processor.process(request);

        assertNotNull(response);
        assertEquals("e412c10b-568a-4410-9e3f-31048f37236f", response.getId());
        assertEquals("Asset 1", response.getName());
        assertEquals("SN1", response.getSerialNumber());
        assertEquals("Description 1", response.getDescription());
        assertEquals(AssetStatus.AVAILABLE.toString(), response.getAssetStatus());
        assertEquals(AssetType.TV.toString(), response.getAssetType());

        verify(assetRepository, times(1)).findById(id);
    }

    @Test
    void testProcess_AssetNotFound() {
        String id = "e412c10b-568a-4410-9e3f-31048f37236f";
        FindByIdAssetOperation.FindByIdAssetRequest request = new FindByIdAssetOperation.FindByIdAssetRequest(id);
        when(assetRepository.findById(UUID.fromString(id))).thenReturn(Optional.empty());

        assertThrows(AssetNotFoundException.class, () -> processor.process(request));

        verify(assetRepository, times(1)).findById(UUID.fromString(id));
    }
}

