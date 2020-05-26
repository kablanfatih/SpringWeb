package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.Item;
import com.kablanfatih.springweb.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User addUser(User user);

    Iterable<User> getUsers();

    List<String> getUsernames();

    User getUserByUsername(String username);

    Object getUserById(long id);

    Map<String, List<Item>> numberOfItemsByType(long userId);
}
