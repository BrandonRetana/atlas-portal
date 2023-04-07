package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {}



