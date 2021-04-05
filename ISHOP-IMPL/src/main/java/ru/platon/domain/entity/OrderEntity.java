package ru.platon.domain.entity;

import java.util.Date;

class OrderEntity {
    private OrderEntity orderEntity;
    private String name;
    private CouponEntity couponEntity;
    private Enum orderStatus;
    private Date orderDate;
}

enum OrderStatus {
    CREATED,
    PAY_WAITING,
    SENT,
    PICK_WAITING,
    DELIVERED
}