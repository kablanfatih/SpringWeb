package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.Item;
import com.kablanfatih.springweb.domain.User;
import com.kablanfatih.springweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public User getUserById(long id) {
        return repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Map<String, List<Item>> numberOfItemsByType(long userId) {
        Map<String, List<Item>> map = new HashMap<String, List<Item>>();
        Set<Item> items = getUserById(userId).getItems();
        for (Item item : items) {
            List<Item> itemList = new ArrayList<Item>();
            String key = item.getType().toLowerCase();
            if (map.containsKey(key))
                itemList = map.get(key);
            itemList.add(item);
            map.put(key, itemList);
        }
        return map;
    }
}
