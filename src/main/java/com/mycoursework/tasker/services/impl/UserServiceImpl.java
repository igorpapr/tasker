package com.mycoursework.tasker.services.impl;

import com.mycoursework.tasker.dao.UserDao;
import com.mycoursework.tasker.entities.Role;
import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.exceptions.ValidationException;
import com.mycoursework.tasker.services.UserService;
import com.mycoursework.tasker.web.dto.UserSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder bcryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder bcryptPasswordEncoder) {
        this.userDao = userDao;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    @Override
    public void insertUser(UserSignUp newUser) throws ValidationException {
        User toInsert = new User(UUID.randomUUID().toString(),
                                 newUser.getEmail(),
                                bcryptPasswordEncoder.encode(newUser.getPassword()),
                                newUser.getUsername(),
                                Role.ROLE_USER);
        try{
            userDao.insertUser(toInsert);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public User getByUsername(String username) {
        User user = null;
        try{
            user = userDao.getByUsername(username);
        } catch(Exception e){
            System.err.println(e.getMessage());
            throw e;
        }
        return user;
    }

    @Override
    public void checkCorrectPassword(User user, String password) {
        if (!bcryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new ValidationException("Incorrect password");
        }
    }


}
