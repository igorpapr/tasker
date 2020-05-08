package com.mycoursework.tasker.dao;

import com.mycoursework.tasker.entities.Task;

import java.util.List;

public interface TaskDao {
	List<Task> getTasksByUserId(String id);

	void addTask(String userId, Task task);
}
