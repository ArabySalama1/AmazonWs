package com.integrant.amazonws.dao;

import com.integrant.amazonws.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("from Order o join fetch o.items where o.id=?1")
    public Order findOrderByIdCustom(int order);
}
