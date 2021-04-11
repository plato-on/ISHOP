package ru.platon;

import ru.platon.domain.entity.CategoryEntity;
import ru.platon.service.CategoryService;
import ru.platon.service.impl.CategoryServiceImpl;

public class IshopApp {

    private static CategoryService categoryService = new CategoryServiceImpl();

    public static void main(String[] args) {

        CategoryEntity entity = new CategoryEntity()
                .setId(1L)
                .setName("First category");

        categoryService.createCategory(entity);
        System.out.println(categoryService.readById(1L).toString());
        categoryService.updateCategory(entity, "BUBEKA", "nahuiSpiski");

    }
}
