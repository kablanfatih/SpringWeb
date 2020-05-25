package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.Item;
import com.kablanfatih.springweb.domain.ItemAddForm;

public interface ItemService {

    void addItem(ItemAddForm form);

    Iterable<Item> getItems();

    void deleteItemById(long id);
}
