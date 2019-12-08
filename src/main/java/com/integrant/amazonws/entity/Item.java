package com.integrant.amazonws.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "items")
public class Item implements Serializable {
    @Id
    private int id;
    private String name;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

  /*  @OneToMany(mappedBy = "item",fetch=FetchType.EAGER)
    @JsonBackReference
    private List<Price> prices;*/

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

    /*public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }*/
}
