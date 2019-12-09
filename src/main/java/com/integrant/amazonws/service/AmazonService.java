package com.integrant.amazonws.service;

import com.integrant.amazonws.dao.CustomerRepository;
import com.integrant.amazonws.dao.ItemRepository;
import com.integrant.amazonws.dao.OrderRepository;
import com.integrant.amazonws.dao.PriceRepository;
import com.integrant.amazonws.entity.Customer;
import com.integrant.amazonws.entity.Item;
import com.integrant.amazonws.entity.Order;
import com.integrant.amazonws.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmazonService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PriceRepository priceRepository;

    public List<Customer> cashCustomer() {

        List<Customer> customerP = customerRepository.findAll();

        return customerP;
    }

    public List<Customer> getCustomers() {

        List<Customer> customerP = customerRepository.findAll();

        return customerP;
    }


    public Customer getCustomer() {

        Optional<Customer> customerP = customerRepository.findById(1);

        return customerP.get();
    }


    public Order getOrder(int id) {
        Optional<Order> orderOp = orderRepository.findById(id);
        if (orderOp.isPresent())
            return orderOp.get();
        return null;
    }

    public Item getItem(int id) {
        Optional<Item> itemOp = itemRepository.findById(id);
        if (itemOp.isPresent())
            return itemOp.get();
        return null;
    }

    public Price getPrice(int id) {
        Optional<Price> priceOp = priceRepository.findById(id);
        if (priceOp.isPresent())
            return priceOp.get();
        return null;
    }
}
