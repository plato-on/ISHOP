package ru.platon.domain.entity;

import lombok.Data;
import ru.platon.repository.CRUDRepository;

import java.util.ArrayList;

@Data
public class CategoryEntity implements CRUDRepository {
    private int id;
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
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    public CategoryEntity(int id, String name, ArrayList<GoodEntity> goodEntities) {
        this.id = id;
        this.name = name;
        this.categoryEntity = categoryEntity;
    }
}
