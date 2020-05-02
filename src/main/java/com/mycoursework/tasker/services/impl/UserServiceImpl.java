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
import java.util.Calendar;
import java.util.List;
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
                                Calendar.getInstance().getTime(),
                                bcryptPasswordEncoder.encode(newUser.getEmail() + newUser.getUsername()),
                                true,
                                Role.ROLE_USER);
//        //TODO - send message with accept code
        try{
            userDao.insertUser(toInsert);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User getByActivationUrl(String activationUrl) {
        return null;
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
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void checkCorrectPassword(User user, String password) {
        if (!bcryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new ValidationException("Incorrect password");
        }
    }


}
