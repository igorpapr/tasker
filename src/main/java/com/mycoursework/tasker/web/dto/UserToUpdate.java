package com.mycoursework.tasker.web.dto;

import com.mycoursework.tasker.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserToUpdate {
	private String email;
	private String password;
	private String username;
	private boolean isActivated;
}
