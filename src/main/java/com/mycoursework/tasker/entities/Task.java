package com.mycoursework.tasker.entities;

import lombok.*;
import java.util.Date;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Task {
	private String taskId;
	private String title;
	private String description;
	private Date deadline;
	private boolean isCompleted;
	private boolean isPublic;
}
