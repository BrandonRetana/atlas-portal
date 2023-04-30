package com.atlas.repository;

import com.atlas.models.taxonModels.Taxon;
import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Class;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Taxon> findByAncestorID(long id);
}

