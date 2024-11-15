package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    private final String title;
    private final String content;
    private final String email;

    public CreateBoardRequestDto(String title, String content, String email) {
        this.title = title;
        this.content = content;
        this.email = email;
    }
}
