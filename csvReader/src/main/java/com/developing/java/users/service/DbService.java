package com.developing.java.users.service;

import com.developing.java.users.domain.User;
import com.developing.java.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
