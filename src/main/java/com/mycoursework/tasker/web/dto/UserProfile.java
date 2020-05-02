package com.mycoursework.tasker.web.dto;

import com.mycoursework.tasker.entities.Role;
import com.mycoursework.tasker.entities.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserProfile {

	private String id;

	private String email;

	private String username;

	private Date creationDate;

	//private String image;

	private Role role;


	public static UserProfile fromUser(User user) {
		return UserProfile.builder()
				.id(user.getId())
				.email(user.getEmail())
				.username(user.getUsername())
				.creationDate(user.getCreationDate())
				//.image(user.getImage())
				.role(user.getRole()).build();
	}

	public static List<UserProfile> fromUsers(List<User> users) {
		List<UserProfile> res = new ArrayList<>();
		users.forEach(user -> res.add(UserProfile.fromUser(user)));
		return res;
	}

}
