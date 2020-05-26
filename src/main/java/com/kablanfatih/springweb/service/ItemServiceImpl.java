package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.Item;
import com.kablanfatih.springweb.domain.ItemAddForm;
import com.kablanfatih.springweb.domain.User;
import com.kablanfatih.springweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final UserService userService;

    @Override
    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            repository.save(item);
        }
    }

    @Override
    public Iterable<Item> getItems() {
        return repository.findAll();
    }

    @Override
    public void deleteItemById(long id) {
        repository.deleteById(id);
    }

    public Object getItemById(long id) {
        return repository.findById(id);
    }

    public Item assignItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = (Item) getItemById(itemId);
        Set<Item> itemList = user.getItems();
        itemList.add(item);
        user.setItems(itemList);
        item.setUser(user);
        return repository.save(item);
    }
}

