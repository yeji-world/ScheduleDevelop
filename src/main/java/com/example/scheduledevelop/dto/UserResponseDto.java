package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;
    private final String username;
    private final String email;

    public UserResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }


    public static UserResponseDto toDto(User user) {

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }
}
