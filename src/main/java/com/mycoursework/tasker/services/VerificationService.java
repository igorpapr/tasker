package com.mycoursework.tasker.services;

import com.mycoursework.tasker.entities.User;

public interface VerificationService {

    String verifyUser(String activationUrl);

    String isUserVerified(User user);
}
