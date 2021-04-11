package ru.platon.repository;

import java.sql.SQLException;

public interface CRUDRepository<T> {
    void create(T t) throws SQLException;
    T readById(Long id);
    void update(Long id);
    void delete(Long id);
}
