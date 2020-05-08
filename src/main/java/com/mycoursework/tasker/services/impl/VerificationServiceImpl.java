package com.mycoursework.tasker.services.impl;

import com.mycoursework.tasker.configs.security.JwtTokenProvider;
import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class VerificationServiceImpl implements VerificationService {

    final private JwtTokenProvider tokenProvider;

    @Autowired
    public VerificationServiceImpl(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public String isUserVerified(User user) {

        if (user == null) {
            throw new ValidationException("User with such username not found");
        }
        return tokenProvider.provideToken(user.getUsername());
    }


}
