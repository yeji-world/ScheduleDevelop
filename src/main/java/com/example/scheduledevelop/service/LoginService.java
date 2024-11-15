package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.LoginRequestDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public void login(LoginRequestDto requestDto) {

        User user = userRepository.findUserByUsernameOrElseThrow(requestDto.getEmail());
        if(!user.getEmail().equals(requestDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이메일을 확인해주세요");
        }

        if(!user.getPassword().equals(requestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호를 확인해주세요");
        }

    }


    }

