package ru.platon.repository.impl;

import ru.platon.domain.entity.CategoryEntity;
import ru.platon.repository.CRUDRepository;
import ru.platon.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepository implements CRUDRepository<CategoryEntity> {

    @Override
    public void create(String query) {

        Statement statement = JDBCUtils.createStatement();

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
    public CategoryEntity readById(String query) {

        Statement statement = JDBCUtils.createStatement();

        if (statement == null) {
            System.out.println("Отсутствует соединение с базой данных");
            return null;
        }

        CategoryEntity resultEntity = new CategoryEntity();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultEntity
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultEntity;
    }

    @Override
    public void update(String query) {

        Statement statement = JDBCUtils.createStatement();

        if (statement == null) {
            System.out.println("Отсутствует соединение с базой данных. Данные, полученные в резальтате выполнения последующих команд недействительны.");
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
    public void delete(String query) {

        Statement statement = JDBCUtils.createStatement();

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
