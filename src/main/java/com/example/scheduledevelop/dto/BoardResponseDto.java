package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public BoardResponseDto(Long id, String title, String content, String username, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }

    public static BoardResponseDto toDto(Board board) {

        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContent(), board.getUser().getUsername(), board.getCreatedAt(), board.getModifiedAt());
    }
}
