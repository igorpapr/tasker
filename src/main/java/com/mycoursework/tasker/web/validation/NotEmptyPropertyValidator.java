package com.mycoursework.tasker.web.validation;

import com.mycoursework.tasker.exceptions.ValidationException;
import org.springframework.util.StringUtils;


public class NotEmptyPropertyValidator {
	public static void isNotEmptyProperty(Object value, String property) {
		if (value == null || StringUtils.isEmpty(value)) {
			throw new ValidationException(String.format("LoginRequest field parameter '%s' must not be empty", property));
		}
	}
}
