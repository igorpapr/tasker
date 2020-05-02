package com.mycoursework.tasker.web.dto;

import com.mycoursework.tasker.entities.User;
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

//    public User toUser(){
//        return User.builder()
//                .username(username)
//                .password(password)
//                .email(email);
//    }
}
