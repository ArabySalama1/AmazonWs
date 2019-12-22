package com.integrant.amazonws.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;



@Entity
@Table(name = "customers")
@Cacheable
@Cache(region = "customer", usage = CacheConcurrencyStrategy.READ_ONLY)
public class Customer implements Serializable {
    @Id
    private int id;
    private String name;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Cache(region = "customer", usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JsonBackReference
    private Set<Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
