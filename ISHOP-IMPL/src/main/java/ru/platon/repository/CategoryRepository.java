package ru.platon.repository;

import ru.platon.domain.entity.CategoryEntity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CategoryRepository implements CRUDRepository {

    @Override
    public void create(Object o) throws SQLException {
        o = DataConnection.statement.executeUpdate("INSERT Category(id, name, goodEntity) VALUES ("+ CategoryEntity.getCategoryEntity
    }

    @Override
    public Object readById(Long id) {
        return new CategoryEntity(id);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {
        categoryEntity.id = null;
    }

}
