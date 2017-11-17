package com.deploy.repository;

import com.deploy.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementJpa extends JpaRepository<Requirement, Integer> {
}
