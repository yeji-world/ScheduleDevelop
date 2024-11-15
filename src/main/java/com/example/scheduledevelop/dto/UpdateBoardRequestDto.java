package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UpdateBoardRequestDto {
    private final String title;
    private final String content;

    public UpdateBoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
