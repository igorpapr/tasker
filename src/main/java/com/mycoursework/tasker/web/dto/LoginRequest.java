package com.mycoursework.tasker.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequest{

    private String username;

    private String password;
}

