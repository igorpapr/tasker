package com.mycoursework.tasker.dao;

import com.mycoursework.tasker.entities.User;

public interface UserDao {

    User getByUsername(String username);

    void insertUser(User user);

}
