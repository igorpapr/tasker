package com.mycoursework.tasker.services;

import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.web.dto.UserSignUp;

import javax.validation.ValidationException;
import java.util.List;

public interface UserService {
    void insertUser(UserSignUp user) throws ValidationException;

    User getById(String id);

    User getByActivationUrl(String activationUrl);

    User getByUsername(String username);

    List<User> getAllUsers();

    User getByEmail(String email);

    void deleteById(String id);

    void update(User user);

    void checkCorrectPassword(User user, String password);
}
