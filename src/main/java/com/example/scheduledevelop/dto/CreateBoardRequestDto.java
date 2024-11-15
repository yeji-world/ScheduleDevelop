package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    private final String title;
    private final String content;
    private final String username;

    public CreateBoardRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
