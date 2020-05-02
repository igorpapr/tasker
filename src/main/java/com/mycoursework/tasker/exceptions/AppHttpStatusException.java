package com.mycoursework.tasker.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Getter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AppHttpStatusException extends RuntimeException{
	public AppHttpStatusException() {
	}
	public AppHttpStatusException(String message) {
		super(message);
	}

	public AppHttpStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpStatus getHttpStatus() {
		return Optional.ofNullable(getClass().getAnnotation(ResponseStatus.class))
				.orElseGet(() -> AppHttpStatusException.class.getAnnotation(ResponseStatus.class))
				.value();
	}
}
