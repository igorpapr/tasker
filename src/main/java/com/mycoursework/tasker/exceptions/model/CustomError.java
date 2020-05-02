package com.mycoursework.tasker.exceptions.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomError {
	private Long timestamp;
	private Integer statusCode;
	private String error;
	private String message;
	private String requestPath;
}

