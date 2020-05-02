package com.mycoursework.tasker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DbException extends AppHttpStatusException{
	public DbException(){
	}
	public DbException(String message) {
		super(message);
	}
	public DbException(String message, Throwable cause) {
		super(message, cause);
	}
}
