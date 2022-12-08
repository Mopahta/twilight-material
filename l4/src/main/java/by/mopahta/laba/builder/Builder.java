package by.bsuir.kaminskiy.builder;

import by.bsuir.kaminskiy.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
