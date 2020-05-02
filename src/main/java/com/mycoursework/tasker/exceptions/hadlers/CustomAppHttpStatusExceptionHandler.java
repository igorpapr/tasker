package com.mycoursework.tasker.exceptions.hadlers;

import com.mycoursework.tasker.exceptions.AppHttpStatusException;
import com.mycoursework.tasker.exceptions.model.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomAppHttpStatusExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomError> handleException(AppHttpStatusException exception,
	                                                   HttpServletRequest request){

		HttpStatus httpStatus = exception.getHttpStatus();

		CustomError errorMessage = CustomError.builder()
				.message(exception.getMessage())
				.statusCode(httpStatus.value())
				.timestamp(System.currentTimeMillis())
				.error(exception.getClass().getName())
				.requestPath(request.getRequestURI())
				.build();

		return new ResponseEntity<>(errorMessage, exception.getHttpStatus());
	}
}
