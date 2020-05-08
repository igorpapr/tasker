package com.mycoursework.tasker.services;

import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.web.dto.UserSignUp;

import javax.validation.ValidationException;

public interface UserService {
    void insertUser(UserSignUp user) throws ValidationException;

    User getByUsername(String username);

    void checkCorrectPassword(User user, String password);
}
