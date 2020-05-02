package com.mycoursework.tasker.dao;

import com.mycoursework.tasker.entities.Task;

import java.util.List;

public interface TaskDao {
	Task getByTaskId(String id);

	List<Task> getTasksByUserId(String id);

	void updateTask(Task newTask);

	void deleteById(String id);

	void addTask(String userId, Task task);
}
