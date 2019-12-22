package com.integrant.amazonws.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "orders")
//@Cacheable
//@Cache(region = "customer", usage = CacheConcurrencyStrategy.READ_ONLY)
public class Order implements Serializable {
    @Id
    private int id;
    @Column(name = "order_number")
    private String orderNumber;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Cache(region = "customer", usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Item> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
