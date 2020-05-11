package com.mycoursework.tasker.dao.impl;

import com.mycoursework.tasker.dao.UserDao;
import com.mycoursework.tasker.dao.rowmappers.UserRowMapper;
import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.exceptions.DbException;
import com.mycoursework.tasker.exceptions.DuplicateKeyWrapperException;
import com.mycoursework.tasker.exceptions.EmptyResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_QUERY = "SELECT id, email, password, username, role " +
            "FROM users ";
    private final String INSERT_QUERY_SINGLE = "INSERT INTO users (id, email, password, username, role) " +
            "VALUES (?, ?, ?, ?, ?);";
    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getByUsername(String username) {
        try{
            return jdbcTemplate.queryForObject( SELECT_QUERY +
                                                    "WHERE username = ? ;",
                    new Object[]{username}, new UserRowMapper());
        } catch (EmptyResultDataAccessException exception){
            throw new EmptyResultException("User Not found with such username: " + username);
        } catch (Exception e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void insertUser(User user) {
        try{
            jdbcTemplate.update(INSERT_QUERY_SINGLE,
                                  user.getId(), user.getEmail(), user.getPassword(),
                                  user.getUsername(), user.getRole().toString());

        }catch (DuplicateKeyException e){
            throw new DuplicateKeyWrapperException(e.getMessage());
        } catch (Exception e1){
            throw new DbException(e1.getMessage());
        }
    }
}
