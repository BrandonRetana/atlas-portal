package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Species;

public interface SpeciesRepository extends JpaRepository<Species, Long> {}




