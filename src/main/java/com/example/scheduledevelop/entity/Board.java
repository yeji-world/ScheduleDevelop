package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

//    @Column(columnDefinition = "longtext")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Board() {
    }

    public Board(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
