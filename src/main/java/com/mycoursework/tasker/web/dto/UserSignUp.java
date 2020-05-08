package com.mycoursework.tasker.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserSignUp{
    private String username;
    private String password;
    private String email;
}
