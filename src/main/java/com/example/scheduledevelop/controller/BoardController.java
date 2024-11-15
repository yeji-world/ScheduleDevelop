package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.BoardOneResponseDto;
import com.example.scheduledevelop.dto.BoardResponseDto;
import com.example.scheduledevelop.dto.CreateBoardRequestDto;
import com.example.scheduledevelop.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> sava(@RequestBody CreateBoardRequestDto requestDto) {

        BoardResponseDto boardResponseDto = boardService.save(requestDto.getTitle(), requestDto.getContent(), requestDto.getUsername());

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {
        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardOneResponseDto> findById(@PathVariable Long id) {

        BoardOneResponseDto boardOneResponseDto = boardService.findById(id);
        return new ResponseEntity<>(boardOneResponseDto, HttpStatus.OK);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
