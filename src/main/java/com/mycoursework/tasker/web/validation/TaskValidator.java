package com.mycoursework.tasker.web.validation;

import com.mycoursework.tasker.exceptions.ValidationException;
import com.mycoursework.tasker.web.dto.TaskToCreate;

public class TaskValidator {

	public static void validate(TaskToCreate task) throws ValidationException {
		NotEmptyPropertyValidator.isNotEmptyProperty(task.getDescription(),"description");
	}
}
