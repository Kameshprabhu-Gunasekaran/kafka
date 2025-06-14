package com.fooddelivery.service;

import com.fooddelivery.repository.OrderEventRepository;
import org.fooddelivery.entity.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventService {

    private final OrderEventRepository repo;
    private static final Logger log = LoggerFactory.getLogger(OrderEventService.class);

    public OrderEventService(OrderEventRepository repo) {
        this.repo = repo;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(OrderEvent event) {
        log.info("received {}", event);
        repo.save(event);
        log.info(" saved id={}", event.getOrderEventId());
    }
}