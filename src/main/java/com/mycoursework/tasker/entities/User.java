package com.mycoursework.tasker.entities;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String id;
    private String email;
    private String password;
    private String username;
    private Role role;

    public User(String id, String email, String password, String username, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}