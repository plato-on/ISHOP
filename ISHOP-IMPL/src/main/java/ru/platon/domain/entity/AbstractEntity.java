package ru.platon.domain.entity;

import ru.platon.repository.CRUDRepository;


public class AbstractEntity implements CRUDRepository {

    @Override
    public void create(Object o) {

    }

    @Override
    public Object readById(Long id) {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
