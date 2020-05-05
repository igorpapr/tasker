package com.mycoursework.tasker.entities;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Task {
	private String taskId;
	private String title;
	private String description;
}
