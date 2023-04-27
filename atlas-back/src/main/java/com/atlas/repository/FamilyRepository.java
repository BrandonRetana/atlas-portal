package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {}




