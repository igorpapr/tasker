package com.mycoursework.tasker.services.impl;

import com.mycoursework.tasker.dao.TaskDao;
import com.mycoursework.tasker.entities.Task;
import com.mycoursework.tasker.services.TaskService;
import com.mycoursework.tasker.web.dto.TaskToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

	TaskDao taskDao;

	@Autowired
	public TaskServiceImpl(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public List<Task> getTasksByUserId(String id) {
		List<Task> res = taskDao.getTasksByUserId(id);
		System.out.println(res);
		return res;
	}

	@Override
	public void addTask(String userId, TaskToCreate task) {
		Task toBeInserted = new Task(
				UUID.randomUUID().toString(),
				task.getTitle(),
				task.getDescription()
		);
		try{
			taskDao.addTask(userId,toBeInserted);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			throw e;
		}
	}
}
