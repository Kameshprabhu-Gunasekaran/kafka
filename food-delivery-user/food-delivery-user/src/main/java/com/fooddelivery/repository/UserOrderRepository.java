package com.fooddelivery.repository;

import org.fooddelivery.dto.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<OrderEvent, String> {
}
