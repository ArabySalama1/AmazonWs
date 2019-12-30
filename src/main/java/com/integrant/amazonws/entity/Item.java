package com.integrant.amazonws.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item implements Serializable {
    @Id
    private int id;
    private String name;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    //@Cache(region = "customer", usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany(mappedBy = "item",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Price> prices;

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


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
}
