package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {}

