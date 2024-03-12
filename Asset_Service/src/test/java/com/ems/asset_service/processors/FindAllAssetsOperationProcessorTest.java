package com.ems.asset_service.processors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ems.asset_service.api.operations.FindAllAssetsOperation;
import com.ems.asset_service.core.processors.FindAllAssetsOperationProcessor;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.enums.AssetStatus;
import com.ems.asset_service.persistence.enums.AssetType;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

public class FindAllAssetsOperationProcessorTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private FindAllAssetsOperationProcessor processor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


}

