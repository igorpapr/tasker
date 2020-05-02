package com.mycoursework.tasker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateKeyWrapperException extends AppHttpStatusException{
	public DuplicateKeyWrapperException(){
	}
	public DuplicateKeyWrapperException(String message) {
		super(message);
	}
	public DuplicateKeyWrapperException(String message, Throwable cause) {
		super(message, cause);
	}
}
