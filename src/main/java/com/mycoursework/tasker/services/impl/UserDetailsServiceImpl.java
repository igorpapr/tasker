package com.mycoursework.tasker.services.impl;

import com.mycoursework.tasker.configs.security.UserDetailsFactory;
import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final private UserService userService;
    private static final String NOT_FOUND_MESSAGE = "User is not found with username : ";

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (user == null) throw new UsernameNotFoundException(NOT_FOUND_MESSAGE + username);
        return UserDetailsFactory.userToJwtUser(user);
    }
}
