package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {}

