package ru.platon.repository;

public interface CRUDRepository<T> {
    void create(String sqlString);
    T readById(String sqlString);
    void update(String sqlString);
    void delete(String sqlString);
}
