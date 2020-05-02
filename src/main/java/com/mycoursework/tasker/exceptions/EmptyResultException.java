package com.mycoursework.tasker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyResultException extends AppHttpStatusException{
	public EmptyResultException(){
	}
	public EmptyResultException(String message) {
		super(message);
	}
	public EmptyResultException(String message, Throwable cause) {
		super(message, cause);
	}
}
