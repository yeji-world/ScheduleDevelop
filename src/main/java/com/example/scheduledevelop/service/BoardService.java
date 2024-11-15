package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.BoardResponseDto;
import com.example.scheduledevelop.dto.CreateBoardRequestDto;
import com.example.scheduledevelop.entity.Board;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.BoardRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(CreateBoardRequestDto requestDto) {

        User findUser = userRepository.findByEmailOrElseTrow(requestDto.getEmail());

        Board board = new Board(requestDto.getTitle(), requestDto.getContent());
        board.setUser(findUser);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContent(), savedBoard.getUser().getUsername());
    }

    public List<BoardResponseDto> findAll() {

        return boardRepository.findAll().stream().map(BoardResponseDto::toDto).toList();
    }

    public BoardResponseDto findById(Long id) {

        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        User writer = findBoard.getUser();

        return new BoardResponseDto(findBoard.getId(), findBoard.getTitle(), findBoard.getContent(), findBoard.getUser().getUsername());
    }


    public BoardResponseDto update(Long id, String title, String content) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);

        findBoard.update(title, content);
        Board savedBoard = boardRepository.save(findBoard);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContent(), savedBoard.getUser().getUsername());
    }

    public void delete(Long id) {

        Board findBoard = boardRepository.findByIdOrElseThrow(id);

        boardRepository.delete(findBoard);
    }
}
