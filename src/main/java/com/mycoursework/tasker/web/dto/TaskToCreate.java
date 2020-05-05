package com.mycoursework.tasker.web.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class TaskToCreate {
	private String title;
	private String description;
}
