package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.User;
import com.kablanfatih.springweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public Iterable<User> getUsers() {
        return repository.findAll();
    }
}
