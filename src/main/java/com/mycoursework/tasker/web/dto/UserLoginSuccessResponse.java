package com.mycoursework.tasker.web.dto;

import com.mycoursework.tasker.entities.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserLoginSuccessResponse{

    private String token;

    public static UserLoginSuccessResponse fromUser(User user) {
        return UserLoginSuccessResponse.builder().build();
    }

}
