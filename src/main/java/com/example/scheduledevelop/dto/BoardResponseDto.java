package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String username;



    public BoardResponseDto(Long id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;

    }

    public static BoardResponseDto toDto(Board board) {

        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContent(), board.getUser().getUsername());
    }
}
