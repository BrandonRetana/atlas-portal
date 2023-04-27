package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Genus;

public interface GenusRepository extends JpaRepository<Genus, Long> {}

