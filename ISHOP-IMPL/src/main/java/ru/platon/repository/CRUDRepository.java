package ru.platon.repository;

public interface CRUDRepository<T> {
    void create(T t);
    T readById(Long id);

}
