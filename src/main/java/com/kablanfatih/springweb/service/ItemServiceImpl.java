package com.kablanfatih.springweb.service;

import com.kablanfatih.springweb.domain.Item;
import com.kablanfatih.springweb.domain.ItemAddForm;
import com.kablanfatih.springweb.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    //private final ItemService service;

    @Override
    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            repository.save(item);
            System.out.println(repository.findById(item.getId()));

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
}

