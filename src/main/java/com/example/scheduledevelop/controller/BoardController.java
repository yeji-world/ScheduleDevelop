package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.BoardResponseDto;
import com.example.scheduledevelop.dto.CreateBoardRequestDto;
import com.example.scheduledevelop.dto.UpdateBoardRequestDto;
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

        BoardResponseDto boardResponseDto = boardService.save(requestDto);

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {
        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> findById(@PathVariable Long id) {

        BoardResponseDto boardResponseDto = boardService.findById(id);
        return new ResponseEntity<>(boardResponseDto, HttpStatus.OK);
        }

    @PatchMapping("/{id}")
    public ResponseEntity<BoardResponseDto> update(@PathVariable Long id, @RequestBody UpdateBoardRequestDto requestDto) {

        BoardResponseDto boardResponseDto = boardService.update(id, requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(boardResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
