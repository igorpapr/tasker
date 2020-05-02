package com.mycoursework.tasker.web.dto;

import com.mycoursework.tasker.entities.Role;
import com.mycoursework.tasker.entities.Task;
import com.mycoursework.tasker.entities.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonalUserProfile {
	private String id;
	private String email;
	private String username;
	private Date creationDate;
	//private String image;
	private Role role;
	private List<Task> taskList;


	public static PersonalUserProfile fromUser(User user) {
		return PersonalUserProfile.builder()
				.id(user.getId())
				.email(user.getEmail())
				.username(user.getUsername())
				.creationDate(user.getCreationDate())
				//.image(user.getImage())
				.role(user.getRole())
				.taskList(user.getTaskList()).build();
	}
}
