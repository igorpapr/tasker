package com.mycoursework.tasker.web.dto;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class TaskToCreate {
	private String title;
	private String description;
}
