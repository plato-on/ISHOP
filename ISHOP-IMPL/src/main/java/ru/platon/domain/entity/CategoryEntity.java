package ru.platon.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.platon.repository.CRUDRepository;

import java.util.ArrayList;

@Data
public class CategoryEntity implements CRUDRepository {
    @Getter
    private Long id;
    private String name;
    private ArrayList<GoodEntity> goodEntities;

    private GoodEntity goodEntity;
    private CategoryEntity categoryEntity;
}
