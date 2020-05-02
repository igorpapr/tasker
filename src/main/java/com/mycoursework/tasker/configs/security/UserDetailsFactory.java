package com.mycoursework.tasker.configs.security;

import com.mycoursework.tasker.entities.Role;
import com.mycoursework.tasker.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsFactory {
   public static UserDetailsImpl userToJwtUser(User user) {
            return UserDetailsImpl.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .authorities(mapToGrantedAuthorities(user.getRole()))
                    .password(user.getPassword())
                    .build();
        }

        private static List<GrantedAuthority> mapToGrantedAuthorities(Role role) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(role.toString()));
            return roles;
        }
}


