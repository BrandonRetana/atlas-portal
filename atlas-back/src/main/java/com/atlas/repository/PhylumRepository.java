package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Phylum;


public interface PhylumRepository extends JpaRepository<Phylum, Long> {}

