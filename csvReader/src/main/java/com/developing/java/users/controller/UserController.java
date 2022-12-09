package com.developing.java.users.controller;

import com.developing.java.users.mapper.UserMapper;
import com.developing.java.users.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class UserController {

    private final DbService service;
    private final UserMapper userMapper;
}
