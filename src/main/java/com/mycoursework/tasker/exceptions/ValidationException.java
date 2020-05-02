package com.mycoursework.tasker.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends AppHttpStatusException{
	public ValidationException(){
	}
	public ValidationException(String message) {
		super(message);
	}
	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
