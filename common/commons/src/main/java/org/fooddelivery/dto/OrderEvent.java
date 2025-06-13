package org.fooddelivery.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderEventId;
    private String message;
    private String status;
    private Order order;

    public String getOrderEventId() {
        return orderEventId;
    }

    public void setOrderEventId(String orderEventId) {
        this.orderEventId = orderEventId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
