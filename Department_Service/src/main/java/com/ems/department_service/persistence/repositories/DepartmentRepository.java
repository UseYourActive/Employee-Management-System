package com.ems.department_service.persistence.repositories;

import com.ems.department_service.persistence.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {

}
