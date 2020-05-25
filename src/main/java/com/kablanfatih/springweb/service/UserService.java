package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    Iterable<User> getUsers();

    List<String> getUsernames();

    User getUserByUsername(String username);


}
