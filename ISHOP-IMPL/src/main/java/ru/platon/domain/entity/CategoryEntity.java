package ru.platon.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@RequiredArgsConstructor
public class CategoryEntity {

    private Long id;
    private String name;
    private ArrayList<GoodEntity> goodEntities;

}