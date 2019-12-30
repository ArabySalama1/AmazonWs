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


    public List<Customer> cashCustomers() {
        return customerRepository.finAllCustomers();
    }

   /* public List<String> getCustomers() {
        List<String> customerP = customerRepository.findCustomers();
        return customerP;
    }*/

    public Customer getCustomerByname(String name) {

        return customerRepository.findByCustomerc(name);
    }

    public Customer getCustomerByOrderId() {
        List<Customer> customer = customerRepository.findByOrdero();
        return customer.get(0);
    }

    public Order getOrderById(int id) {
        return orderRepository.findOrderByIdCustom(id);
    }

    public Integer getSumOfPrices() {
        return customerRepository.countById(1);
    }


    public Order getOrder(int id) {
        Optional<Order> orderOp = orderRepository.findById(id);
        return orderOp.orElse(null);
    }

    public Item getItem(int id) {
        Optional<Item> itemOp = itemRepository.findById(id);
        return itemOp.orElse(null);
    }

    public Price getPrice(int id) {
        Optional<Price> priceOp = priceRepository.findById(id);
        return priceOp.orElse(null);
    }
}
