package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {}



