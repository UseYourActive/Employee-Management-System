package com.ems.training_and_development_service.persistence.repositories;

import com.ems.training_and_development_service.persistence.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
