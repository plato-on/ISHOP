package ru.platon.repository;

import ru.platon.domain.entity.CategoryEntity;

import java.sql.SQLException;

public interface CRUDRepository<T> {
    void create(T t) throws SQLException;
    T readById(Long id);
    void update(Long id, String name, String goodEntities);
    void delete(Long id);
}
