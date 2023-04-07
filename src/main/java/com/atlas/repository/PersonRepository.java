package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}



