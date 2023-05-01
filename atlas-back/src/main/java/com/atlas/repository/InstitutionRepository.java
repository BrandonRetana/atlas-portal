package com.atlas.repository;

import com.atlas.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
