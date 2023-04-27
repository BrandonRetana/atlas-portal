package com.atlas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atlas.models.taxonModels.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}


