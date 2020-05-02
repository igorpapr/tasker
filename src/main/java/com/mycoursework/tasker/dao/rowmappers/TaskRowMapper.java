package com.mycoursework.tasker.dao.rowmappers;

import com.mycoursework.tasker.entities.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet resultSet, int i) throws SQLException {
		return new Task(
				resultSet.getString("task_id"),
				resultSet.getString("title"),
				resultSet.getString("description"),
				resultSet.getDate("deadline"),
				resultSet.getBoolean("completed"),
				resultSet.getBoolean("is_public"));
	}
}
