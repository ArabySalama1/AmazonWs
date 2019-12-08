package com.integrant.amazonws.dao;

import com.integrant.amazonws.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer> {
}
