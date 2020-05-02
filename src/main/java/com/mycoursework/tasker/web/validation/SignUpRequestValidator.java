package com.mycoursework.tasker.web.validation;

import com.mycoursework.tasker.exceptions.ValidationException;
import com.mycoursework.tasker.web.dto.UserSignUp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpRequestValidator {

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." +
			"[a-zA-Z0-9_+&*-]+)*@" +
			"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
			"A-Z]{2,7}$";

	public static void validate(UserSignUp signUpRequest) throws ValidationException {
		NotEmptyPropertyValidator.isNotEmptyProperty(signUpRequest.getUsername(),"username");
		NotEmptyPropertyValidator.isNotEmptyProperty(signUpRequest.getPassword(),"password");
		NotEmptyPropertyValidator.isNotEmptyProperty(signUpRequest.getEmail(),"email");
		matches(signUpRequest.getEmail());

	}

	private static void matches(String input){
		Matcher matcher = Pattern.compile(SignUpRequestValidator.EMAIL_REGEX).matcher(input);
		if (!matcher.matches()) {
			throw new ValidationException("Input of property email must match all the parameters.");
		}
	}
}
