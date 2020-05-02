package com.mycoursework.tasker.dao.rowmappers;

import com.mycoursework.tasker.entities.Role;
import com.mycoursework.tasker.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User(
            resultSet.getString("id"),
            resultSet.getString("email"),
                resultSet.getString("password"),
                resultSet.getString("username"),
                resultSet.getDate("creation_date"),
                resultSet.getString("activation_url"),
                resultSet.getBoolean("is_activated"),
                Role.valueOf(resultSet.getString("role")));
    }
}
