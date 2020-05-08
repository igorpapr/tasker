package com.mycoursework.tasker.web.сontrollers;

import com.mycoursework.tasker.configs.Constants;
import com.mycoursework.tasker.entities.User;
import com.mycoursework.tasker.exceptions.ValidationException;
import com.mycoursework.tasker.services.UserService;
import com.mycoursework.tasker.services.VerificationService;
import com.mycoursework.tasker.web.dto.LoginRequest;
import com.mycoursework.tasker.web.dto.UserLoginSuccessResponse;
import com.mycoursework.tasker.web.dto.UserSignUp;
import com.mycoursework.tasker.web.validation.SignUpRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(Constants.AUTH_URLS)
public class AuthorizationController {

    VerificationService verificationService;
    UserService userService;

    @Autowired
    public AuthorizationController(UserService userService, VerificationService verificationService) {
        this.userService = userService;
        this.verificationService = verificationService;
    }

    @PostMapping("login")
    public ResponseEntity<UserLoginSuccessResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.toString());
        
        User currentUser = userService.getByUsername(loginRequest.getUsername());

        userService.checkCorrectPassword(currentUser, loginRequest.getPassword());
        UserLoginSuccessResponse successResponse = UserLoginSuccessResponse.fromUser(currentUser);
        successResponse.setToken(verificationService.isUserVerified(currentUser));
        System.out.println(successResponse);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<?> register(@RequestBody UserSignUp signUpUser) throws ValidationException{

        SignUpRequestValidator.validate(signUpUser);
        userService.insertUser(signUpUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
