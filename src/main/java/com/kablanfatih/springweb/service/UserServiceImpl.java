package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.User;
import com.kablanfatih.springweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();
        for (User user : getUsers()) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
