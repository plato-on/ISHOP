package ru.platon.domain.entity;

import java.util.ArrayList;

class CategoryEntity {
    private int id;
    private GoodEntity goodEntity;
    private CategoryEntity categoryEntity;
    private String name;
    private ArrayList<GoodEntity> goodEntities;
}
