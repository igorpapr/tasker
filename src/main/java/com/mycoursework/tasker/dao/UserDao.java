package com.mycoursework.tasker.dao;

import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.web.dto.UserToUpdate;

import java.util.List;

public interface UserDao {

    //User getByEmail(String email);

    User getByUsername(String username);

    User getById(String id);

    void insertUser(User user);

    List<User> getAllUsers();

    //void deleteById(String id);

    void update(UserToUpdate user, String id);

   // List<User> getAll();

    //User getByActivationUrl(String activationUrl);

    //User getByRecoverUrl(String recoverUrl);

    //List<User> getBySubStr(String str);

 //   int userRating(String userId);

}
