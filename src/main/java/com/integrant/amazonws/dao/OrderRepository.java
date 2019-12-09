package com.integrant.amazonws.dao;

import com.integrant.amazonws.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
