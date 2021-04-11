package ru.platon.domain.entity;

import ru.platon.repository.CRUDRepository;

import java.util.ArrayList;

public class CouponEntity {
    private int id;
    private String name;
    ArrayList<OrderEntity> orderEntities;

}
