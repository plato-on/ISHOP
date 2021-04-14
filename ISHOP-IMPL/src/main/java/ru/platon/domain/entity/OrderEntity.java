package ru.platon.domain.entity;

import java.time.OffsetDateTime;

public class OrderEntity {
    private int id;
    private String name;
    private OffsetDateTime orderDate;
    private Enum orderStatus;
}

enum OrderStatus {
    CREATED,
    PAY_WAITING,
    SENT,
    PICK_WAITING,
    DELIVERED
}