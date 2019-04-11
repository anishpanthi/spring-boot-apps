package com.app.boot.jpa.service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anish
 */
public interface BaseService<T, R> {

    Optional<R> findOne(T t);

    List<R> findAll();

    R create(R r);

    void delete(T t);

    R update(R r);
}
