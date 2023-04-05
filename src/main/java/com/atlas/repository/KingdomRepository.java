package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Kingdom;

public interface KingdomRepository extends JpaRepository<Kingdom, Long> {}