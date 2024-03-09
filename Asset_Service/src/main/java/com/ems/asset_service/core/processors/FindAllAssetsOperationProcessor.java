package com.ems.asset_service.core.processors;

import com.ems.asset_service.api.operations.FindAllAssetsOperation;
import com.ems.asset_service.persistence.entities.Asset;
import com.ems.asset_service.persistence.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class FindAllAssetsOperationProcessor implements FindAllAssetsOperation {
    private final AssetRepository assetRepository;

    @Override
    public FindAllAssetsResponse process(final FindAllAssetsRequest request) {
        log.info("Processing find all assets request: {}", request);

        PageRequest pageRequest = PageRequest.of(
                request.getPageNumber(),
                request.getNumberOfBooksPerPage());

        log.debug("Fetching assets from database with page request: {}", pageRequest);

        List<FindAllAssetsResponseDTO> list = assetRepository.findAll(pageRequest)
                .stream()
                .map(this::map)
                .toList();

        log.info("Found {} assets", list.size());

        return FindAllAssetsResponse.builder()
                .findAllAssetsResponseDTOS(list)
                .build();
    }

    private FindAllAssetsResponseDTO map(Asset asset){
        return FindAllAssetsResponseDTO.builder()
                .id(String.valueOf(asset.getId()))
                .description(asset.getDescription())
                .name(asset.getName())
                .serialNumber(asset.getSerialNumber())
                .build();
    }
}
