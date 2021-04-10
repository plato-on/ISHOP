package ru.platon.domain.entity;

import java.time.OffsetDateTime;

public class OrderEntity {
    private int id;
    private OrderEntity orderEntity;
    private String name;
    private CouponEntity couponEntity;
    private Enum orderStatus;
    private OffsetDateTime orderDate;
}

enum OrderStatus {
    CREATED,
    PAY_WAITING,
    SENT,
    PICK_WAITING,
    DELIVERED
}