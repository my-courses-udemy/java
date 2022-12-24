package org.aguzman.java.jdbc.repositorio;

import java.util.List;

public interface Repository<T> {
    List<T> list();

    T byId(Long id);

    void store(T t);

    void delete(Long id);
}
