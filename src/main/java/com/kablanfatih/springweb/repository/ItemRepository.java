package com.kablanfatih.springweb.repository;

import com.kablanfatih.springweb.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
