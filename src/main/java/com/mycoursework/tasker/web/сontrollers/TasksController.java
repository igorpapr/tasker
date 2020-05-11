package com.mycoursework.tasker.web.сontrollers;

import com.mycoursework.tasker.configs.Constants;
import com.mycoursework.tasker.configs.security.facade.IAuthenticationFacade;
import com.mycoursework.tasker.entities.Task;
import com.mycoursework.tasker.services.TaskService;
import com.mycoursework.tasker.web.dto.TaskToCreate;
import com.mycoursework.tasker.web.validation.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(Constants.TASKS_URLS)
public class TasksController {

	TaskService taskService;
	IAuthenticationFacade authenticationFacade;

	@Autowired
	public TasksController(TaskService taskService, IAuthenticationFacade authenticationFacade) {
		this.taskService = taskService;
		this.authenticationFacade = authenticationFacade;
	}

	@PostMapping
	public ResponseEntity<?> addTaskToUserProfile(@RequestBody TaskToCreate taskToCreate) {
		System.out.println(taskToCreate);
		TaskValidator.validate(taskToCreate);

		taskService.addTask(authenticationFacade.getUserId(), taskToCreate);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Task>> getTasksOfUser() {
		List<Task> res = taskService.getTasksByUserId(authenticationFacade.getUserId());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}


