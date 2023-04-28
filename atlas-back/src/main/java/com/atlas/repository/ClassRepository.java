package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.TClass;

public interface ClassRepository extends JpaRepository<TClass, Long> {}

