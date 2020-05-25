package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.User;

public interface UserService {

    User addUser(User user);

    Iterable<User> getUsers();
}
