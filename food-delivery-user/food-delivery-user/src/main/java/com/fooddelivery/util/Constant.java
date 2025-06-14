package com.fooddelivery.util;

public class Constant {

    private Constant() {
    }
    public static final String ORDER_STATUS_PENDING = "PENDING";
    public static final String ORDER_MESSAGE_PENDING = "Order received and pending";
    public static final String ORDER_SUCCESS = "Order placed successfully";

    public static final String ORDER_SAVED_LOG = "OrderEvent persisted to DB ";
    public static final String ORDER_SENT_LOG = "OrderEvent sent to Kafka topic ";

}