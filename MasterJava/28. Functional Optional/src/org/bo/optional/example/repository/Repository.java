package org.bo.optional.example.repository;

import org.bo.optional.example.models.Computer;

import java.util.Optional;

public interface Repository<T> {

    Optional<Computer> filter(String name);

}
