package com.fooddelivery.service;

import com.fooddelivery.repository.UserOrderRepository;
import com.fooddelivery.util.Constant;
import jakarta.transaction.Transactional;
import org.apache.kafka.clients.admin.NewTopic;
import org.fooddelivery.entity.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final UserOrderRepository orderRepository;
    private final String topicName;

    public OrderService(KafkaTemplate<String, OrderEvent> kafkaTemplate,
                        UserOrderRepository orderRepository,
                        org.apache.kafka.clients.admin.NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
        this.topicName = topic.name();
    }

    @Transactional
    public void publishOrderEvent(OrderEvent event) {

        orderRepository.save(event.getOrder());

        log.info(Constant.ORDER_SAVED_LOG, event.getOrderEventId());

        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .setHeader(KafkaHeaders.KEY, event.getOrder().getOrderId())
                .build();

        kafkaTemplate.send(message);
        log.info(Constant.ORDER_SENT_LOG, event.getOrderEventId(), topicName);
    }
}
