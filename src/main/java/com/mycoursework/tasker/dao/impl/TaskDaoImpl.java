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

	private String SELECT_QUERY = "SELECT task_id, title, description, deadline, completed, is_public " +
								  "FROM tasks ";
	private String INSERT_QUERY = "INSERT INTO tasks (task_id, title, description, deadline, completed, user_id, is_public) " +
									"VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE_QUERY = "UPDATE tasks" +
									"SET title = ?, description = ?, deadline = ?, completed = ?, is_public = ? ";

	private String DELETE_QUERY = "DELETE FROM tasks " +
									"WHERE task_id = ? ;";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Task getByTaskId(String id) {
		try{
			return jdbcTemplate.queryForObject( SELECT_QUERY +
												"WHERE task_id = ? ;",
					new Object[]{id}, new TaskRowMapper());
		} catch (EmptyResultDataAccessException exception){
			throw new EmptyResultException("Task wasn't found with such id: " + id);
		} catch (Exception e){
			throw new DbException(e.getMessage());
		}
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
	public void updateTask(Task newTask) {
		try{
			jdbcTemplate.update( UPDATE_QUERY +
									"WHERE task_id = ? ;",
					newTask.getTitle(), newTask.getDescription(), newTask.getDeadline(), newTask.isCompleted(),
					newTask.isPublic(), newTask.getTaskId());
		} catch (EmptyResultDataAccessException exception) {
			throw new EmptyResultException("Task wasn't found with such id: " + newTask.getTaskId());
		}catch (Exception e){
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(String id) {
		try{
			jdbcTemplate.update(DELETE_QUERY, id);
		}catch (Exception e){
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void addTask(String userId, Task task) {
		try{
			jdbcTemplate.update(INSERT_QUERY,
					task.getTaskId(),
					task.getTitle(), task.getDescription(), task.getDeadline(), task.isCompleted(),
					userId,
					task.isPublic());
		}catch (DuplicateKeyException e){
			throw new DuplicateKeyWrapperException(e.getMessage());
		}catch (Exception e1){
			throw new DbException(e1.getMessage());
		}
	}
}
