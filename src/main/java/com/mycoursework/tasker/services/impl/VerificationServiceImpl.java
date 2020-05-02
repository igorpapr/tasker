package com.mycoursework.tasker.services.impl;

import com.mycoursework.tasker.configs.security.JwtTokenProvider;
import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.services.UserService;
import com.mycoursework.tasker.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Date;

import static javax.management.timer.Timer.ONE_DAY;

@Service
public class VerificationServiceImpl implements VerificationService {

    final private JwtTokenProvider tokenProvider;
    final private UserService userService;

    @Autowired
    public VerificationServiceImpl(JwtTokenProvider tokenProvider, UserService userService) {
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @Override
    public String verifyUser(String activationUrl) {

        User user = userService.getByActivationUrl(activationUrl);
        if (user == null) {
            throw new ValidationException("Not Found");
        }

        //return to log in with message that already activated
        //if (user.isVerified()) {
        //    return MESSAGE_ALREADY_ACTIVATED;
        //}

        //return to log in with message that activation link have been expired
        //if (new Date().getTime() - user.getCreationDate().getTime() >= ONE_DAY) {
        //    userService.deleteById(user.getId());
        //    return MESSAGE_LINK_EXPIRED;
        //}

        //user.setVerified(true);
        //user.setActivated(true);
        //userService.update(user);

        return null;//MESSAGE_ACTIVATED;
    }


    @Override
    public String isUserVerified(User user) {

        if (user == null) {
            throw new ValidationException("User with such username not found");
        }

        //if (!user.isVerified()) {
        //    throw new ValidationException("Your profile is not activated");
        //}

        //user.setOnline(true);
        //userService.update(user);

        return tokenProvider.provideToken(user.getUsername());
    }


}
