package com.integrant.amazonws.dao;

import com.integrant.amazonws.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query("select distinct p.price,COUNT(c.name) from Customer c  join Order o on c.id=o.customer.id join Item i on o.id=i.order.id join Price p on i.id=p.item.id group by p.price having COUNT(c.name) in (select distinct  c.id from Customer c join Order o on c.id=o.customer.id join Item i on o.id=i.order.id join Price p on i.id=p.item.id )")
    public List<String> findCustomers(Pageable pageable);

    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
            @QueryHint(name = "org.hibernate.cacheRegion", value = "CacheRegion")
    })
    List<Customer> findAll();

}