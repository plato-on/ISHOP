package ru.platon.service;

import ru.platon.domain.entity.CategoryEntity;

public interface CategoryService {

    void createCategory(CategoryEntity categoryEntity);

    CategoryEntity readById(Long id);

    void updateCategory(CategoryEntity categoryEntity, String newName, String newGoodEntities);

    void deleteCategory(Long id);
}
