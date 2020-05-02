package com.mycoursework.tasker.web.dto;


import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class TaskToCreate {
	private String title;
	private String description;
	private Date deadline;
	private boolean isCompleted;
	private boolean isPublic;
}
