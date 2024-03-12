package com.ems.asset_service.processors;

import com.ems.asset_service.api.operations.CreateNewAssetOperation;
import com.ems.asset_service.core.processors.CreateNewAssetOperationProcessor;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.enums.AssetStatus;
import com.ems.asset_service.persistence.enums.AssetType;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateNewAssetOperationProcessorTest {
    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private CreateNewAssetOperationProcessor processor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcess_SuccessfullyCreated() {
        CreateNewAssetOperation.CreateNewAssetRequest request = new CreateNewAssetOperation.CreateNewAssetRequest();
        request.setName("Laptop");
        request.setDescription("New laptop for development team");
        request.setSerialNumber("123456789");
        request.setAssetType("COMPUTER");

        Asset asset = Asset.builder()
                .name("Laptop")
                .description("New laptop for development team")
                .serialNumber("123456789")
                .assetStatus(AssetStatus.AVAILABLE)
                .assetType(AssetType.COMPUTER)
                .build();

        when(assetRepository.save(any(Asset.class))).thenReturn(asset);

        CreateNewAssetOperation.CreateNewAssetResponse response = processor.process(request);

        assertNotNull(response);
        assertNotNull(response.getId());
        assertEquals("Laptop", response.getName());
        assertEquals("123456789", response.getSerialNumber());
        assertEquals("New laptop for development team", response.getDescription());
        assertEquals(AssetStatus.AVAILABLE.toString(), response.getAssetStatus());
        assertEquals(AssetType.COMPUTER.toString(), response.getAssetType());

        verify(assetRepository, times(1)).save(any(Asset.class));
    }

    @Test
    void testProcess_SaveReturnsNull() {
        CreateNewAssetOperation.CreateNewAssetRequest request = new CreateNewAssetOperation.CreateNewAssetRequest();
        request.setName("Laptop");
        request.setDescription("New laptop for development team");
        request.setSerialNumber("123456789");
        request.setAssetType("COMPUTER");

        when(assetRepository.save(any(Asset.class))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> processor.process(request));

        verify(assetRepository, times(1)).save(any(Asset.class));
    }

    @Test
    void testProcess_NullFieldsInRequest() {
        CreateNewAssetOperation.CreateNewAssetRequest request = new CreateNewAssetOperation.CreateNewAssetRequest();
        request.setName("Laptop");
        request.setDescription("New laptop for development team");

        assertThrows(NullPointerException.class, () -> processor.process(request));
    }
}
