package ru.platon.repository.impl;

import ru.platon.domain.entity.CategoryEntity;
import ru.platon.repository.CRUDRepository;
import ru.platon.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepository implements CRUDRepository<CategoryEntity> {

    @Override
    public void create(CategoryEntity categoryEntity) {

        Statement statement = JDBCUtils.createStatement();
        String query = String.format("INSERT category(id, name, goodEntity) VALUES (%s, %s, %s)", categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getGoodEntities());

        if (statement == null) {
            System.out.println("Отсутствует соединение с базой данных");
            return;
        }

        try {
            statement.executeUpdate(query);
            System.out.println("Объект успешно создан");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Объект не был создан" + e);
        }
    }

    @Override
    public CategoryEntity readById(Long id) {

        Statement statement = JDBCUtils.createStatement();
        String query = String.format("SELECT * FROM category c where c.id = %d", id);

        if (statement == null) {
            System.out.println("Отсутствует соединение с базой данных");
            return null;
        }

        CategoryEntity resultEntity = new CategoryEntity();

        try {
            ResultSet rs = statement.executeQuery(query);

            resultEntity
                    .setId(rs.getLong("id"))
                    .setName(rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultEntity;
    }

    @Override
    public void update(Long id, String name, String goodEntities) {

        Statement statement = JDBCUtils.createStatement();
        String query = String.format("UPDATE category SET name = %s, goodEntity = %s WHERE id = %d", name, goodEntities, id);

        if (statement == null) {
            System.out.println("Отсутствует соединение с базой данных");
        }

        try {
            assert statement != null;
            statement.executeUpdate(query);
            System.out.println("Объект успешно обновлен");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Объект не был обновлен" + e);
        }
    }

    @Override
    public void delete(Long id) {

        Statement statement = JDBCUtils.createStatement();
        String query = String.format("DELETE FROM category WHERE id = %s", id);

        if (statement == null) {
            System.out.println("Отсутствует соединение с базой данных");
        }

        try {
            assert statement != null;
            statement.executeUpdate(query);
            System.out.println("Объект успешно удалён");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Объект не был удалён" + e);
        }

    }

}
