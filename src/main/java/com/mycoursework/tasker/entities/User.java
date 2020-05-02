package com.mycoursework.tasker.entities;

import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String id;
    private String email;
    private String password;
    private String username;
    private Date creationDate;
    private String activationUrl;
    private boolean isActivated;
    private Role role;
    private List<Task> taskList;

    public User(String id, String email, String password,
                String username, Date creationDate,
                String activationUrl, boolean isActivated, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.creationDate = creationDate;
        this.activationUrl = activationUrl;
        this.isActivated = isActivated;
        this.role = role;
        this.taskList = null;
    }

    public User(String id, String email, String password, String username, Date creationDate, String activationUrl, boolean isActivated, Role role, List<Task> taskList) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.creationDate = creationDate;
        this.activationUrl = activationUrl;
        this.isActivated = isActivated;
        this.role = role;
        this.taskList = taskList;
    }
}