package com.sem4.wcd.assign.service;

import java.util.List;

public interface IService<E> {

    List<E> getAll();

    E getById(Long id);

    boolean create(E e);

    boolean update(E e);

    boolean delete(Long id);
}
