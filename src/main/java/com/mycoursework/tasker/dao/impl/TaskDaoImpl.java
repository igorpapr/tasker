package com.mycoursework.tasker.dao.impl;

import com.mycoursework.tasker.dao.TaskDao;
import com.mycoursework.tasker.dao.rowmappers.TaskRowMapper;
import com.mycoursework.tasker.entities.Task;
import com.mycoursework.tasker.exceptions.DbException;
import com.mycoursework.tasker.exceptions.DuplicateKeyWrapperException;
import com.mycoursework.tasker.exceptions.EmptyResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

	private String SELECT_QUERY = "SELECT task_id, title, description " +
								  "FROM tasks ";
	private String INSERT_QUERY = "INSERT INTO tasks (task_id, title, description, user_id) " +
									"VALUES (?, ?, ?, ?)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Task> getTasksByUserId(String id) {
		try{
			return jdbcTemplate.query( SELECT_QUERY +
									"WHERE user_id = ? ;",
					new Object[]{id}, new TaskRowMapper());
		} catch (Exception e){
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void addTask(String userId, Task task) {
		try{
			jdbcTemplate.update(INSERT_QUERY,
					task.getTaskId(),
					task.getTitle(), task.getDescription(),
					userId);
		}catch (DuplicateKeyException e){
			throw new DuplicateKeyWrapperException(e.getMessage());
		}catch (Exception e1){
			throw new DbException(e1.getMessage());
		}
	}
}
