package ru.platon.domain.entity;

import lombok.Data;
import ru.platon.repository.CRUDRepository;

import java.util.ArrayList;

@Data
public class CategoryEntity implements CRUDRepository {
    private Long id;
    private String name;
    private ArrayList<GoodEntity> goodEntities;

    private GoodEntity goodEntity;
    private CategoryEntity categoryEntity;

    @Override
    public void create(Object o) {
        o = new CategoryEntity(id, name, goodEntities);
    }

    @Override
    public Object readById(Long id) {
        return new CategoryEntity(id);
    }

    @Override
    public void update(Object o) {
        o = new CategoryEntity(categoryEntity.id, categoryEntity.name, categoryEntity.goodEntities);
    }

    @Override
    public void delete(Long id) {
        categoryEntity.id = null;
    }

    private CategoryEntity(Long id, String name, ArrayList<GoodEntity> goodEntities) {
        this.id = id;
        this.name = name;
        this.goodEntities = goodEntities;
    }

    private CategoryEntity(Long id) {
        this.id = id;
    }
}
