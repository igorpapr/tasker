package com.mycoursework.tasker.web.dto;

import com.mycoursework.tasker.entities.Role;
import com.mycoursework.tasker.entities.User;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserLoginSuccessResponse{

    //private boolean success;

    private String token;

    //private String id;

    //private String email;

    //private String username;

    //private Date creationDate;

    //private String image;

    //private Role role;

    public static UserLoginSuccessResponse fromUser(User user) {
        return UserLoginSuccessResponse.builder().build();
                //.id(user.getId())
                //.email(user.getEmail())
                //.username(user.getUsername())
                //.creationDate(user.getCreationDate())
                //.image(user.getImage())
                //.role(user.getRole()).build();
    }

}
