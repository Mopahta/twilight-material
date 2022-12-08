package by.bsuir.kaminskiy.repository.impl;

import by.bsuir.kaminskiy.builder.Builder;
import by.bsuir.kaminskiy.builder.UserBuilder;
import by.bsuir.kaminskiy.entity.User;
import by.bsuir.kaminskiy.exception.RepositoryException;
import by.bsuir.kaminskiy.repository.AbstractRepository;
import by.bsuir.kaminskiy.specification.Specification;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {
    private static final String TABLE_NAME = "user";
    private static final String SELECT_QUERY = "SELECT * FROM user ";

    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(User item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(USERNAME, item.getUsername());
        values.put(PASSWORD, item.getPassword());
        values.put(ROLE, item.getRole());
        values.put(ID, item.getId());
        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<User> query(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<User> builder = new UserBuilder();
        List<Object> params = specification.getParameters();
        return executeQueryForSingleResult(query, builder, params);
    }

    @Override
    public List<User> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<User> builder = new UserBuilder();
        List<Object> params = specification.getParameters();
        return executeQuery(query, builder, params);
    }

}
