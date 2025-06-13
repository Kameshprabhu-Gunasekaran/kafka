package com.fooddelivery.repository;

import com.fooddelivery.Service.OrderConsumer;
import org.fooddelivery.dto.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderConsumerRepository extends JpaRepository<OrderEvent, String> {
}
