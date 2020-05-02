package com.mycoursework.tasker.services;

import com.mycoursework.tasker.entities.Task;
import com.mycoursework.tasker.web.dto.TaskToCreate;

import java.util.List;

public interface TaskService {

	Task getByTaskId(String id);

	List<Task> getTasksByUserId(String id);

	void updateTask(Task newTask);

	void deleteById(String id);

	void addTask(String userId, TaskToCreate task);
}
