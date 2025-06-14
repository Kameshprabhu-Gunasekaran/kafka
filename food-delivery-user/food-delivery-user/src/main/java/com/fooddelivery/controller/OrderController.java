package com.fooddelivery.controller;

import com.fooddelivery.service.OrderService;
import com.fooddelivery.util.Constant;
import org.fooddelivery.entity.Order;
import org.fooddelivery.entity.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus(Constant.ORDER_STATUS_PENDING);
        orderEvent.setMessage(Constant.ORDER_MESSAGE_PENDING);
        orderEvent.setOrder(order);

        log.info("HTTP /orders -> {}", order);

        orderService.publishOrderEvent(orderEvent);

        return ResponseEntity.ok(Constant.ORDER_SUCCESS);
    }
}
