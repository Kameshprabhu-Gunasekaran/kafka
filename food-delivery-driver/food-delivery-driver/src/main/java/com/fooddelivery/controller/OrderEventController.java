package com.fooddelivery.controller;

import com.fooddelivery.repository.OrderEventRepository;
import org.fooddelivery.entity.OrderEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver/orders")
public class OrderEventController {

    private final OrderEventRepository repository;

    public OrderEventController(OrderEventRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/retrieve")
    public List<OrderEvent> getAllOrders() {
        return repository.findAll();
    }

    @GetMapping("/retrieve/{id}")
    public OrderEvent getOrderById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
