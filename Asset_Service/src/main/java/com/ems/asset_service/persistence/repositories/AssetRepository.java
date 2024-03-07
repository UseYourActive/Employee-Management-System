package com.ems.asset_service.persistence.repositories;

import com.ems.asset_service.persistence.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssetRepository extends JpaRepository<Asset, UUID> {
}
