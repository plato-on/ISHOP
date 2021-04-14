package ru.platon.service.impl;

import ru.platon.domain.entity.CategoryEntity;
import ru.platon.repository.impl.CategoryRepository;
import ru.platon.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    public enum Singleton {
        INSTANCE;
        private synchronized CategoryRepository getCategorySingleton() {
            return new CategoryRepository();
        }
    }

    private final CategoryRepository categoryRepository = Singleton.INSTANCE.getCategorySingleton();

    @Override
    public void createCategory(CategoryEntity categoryEntity) {
        String query = String.format("INSERT category(id, name, goodEntity) VALUES (%s, %s, %s)", categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getGoodEntities());
        categoryRepository.create(query);
    }

    @Override
    public CategoryEntity readById(Long id) {
        String query = String.format("SELECT * FROM category c where c.id = %d", id);
        return categoryRepository.readById(query);
    }

    @Override
    public void updateCategory(CategoryEntity categoryEntity, String newName, String newGoodEntities) {
        String query = String.format("UPDATE category SET name = %s, goodEntity = %s WHERE id = %d", newName, newGoodEntities, categoryEntity.getId());
        categoryRepository.update(query);
    }

    @Override
    public void deleteCategory(Long id) {
        String query = String.format("DELETE FROM category WHERE id = %s", id);
        categoryRepository.delete(query);
    }

}