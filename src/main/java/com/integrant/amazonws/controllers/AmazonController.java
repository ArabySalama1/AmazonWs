package com.integrant.amazonws.controllers;

import com.integrant.amazonws.entity.Customer;
import com.integrant.amazonws.entity.Item;
import com.integrant.amazonws.entity.Order;
import com.integrant.amazonws.entity.Price;
import com.integrant.amazonws.service.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/amazonws")
public class AmazonController {

    @Autowired
    private AmazonService amazonService;

    @GetMapping(path = "/cacheCustomer", produces = "application/json")
    @ResponseBody
    public Customer cacheCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> list = amazonService.cashCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Cache Elapsed Time is :" + (end - start));
        return list.get(0);
    }


    @GetMapping(path = "/customer/name/{name}", produces = "application/json")
    @ResponseBody
    public Customer getCustomerByName(@PathVariable("name") String name) {
        long start = System.currentTimeMillis();
        Customer customer = amazonService.getCustomerByname(name);
        long end = System.currentTimeMillis();
        System.out.println("Cache Elapsed Time is :" + (end - start));
        return customer;
    }

    @GetMapping(path = "/customer/orderId/{id}", produces = "application/json")
    @ResponseBody
    public Customer getCustomerByOrderId(@PathVariable("id") int id) {
        long start = System.currentTimeMillis();
        Customer customer = amazonService.getCustomerByOrderId();
        long end = System.currentTimeMillis();
        System.out.println("Cache Elapsed Time is :" + (end - start));
        return customer;
    }

    @GetMapping(path = "/customer/prices/count", produces = "application/json")
    @ResponseBody
    public Integer getPricesCount() {
        long start = System.currentTimeMillis();
        Integer sum = amazonService.getSumOfPrices();
        long end = System.currentTimeMillis();
        System.out.println("Cache Elapsed Time is :" + (end - start));
        return sum;
    }


    @GetMapping(path = "/order/{id}", produces = "application/json")
    @ResponseBody
    public Order getOrderId(@PathVariable("id") int id) {
        long start = System.currentTimeMillis();
        Order order = amazonService.getOrderById(id);
        long end = System.currentTimeMillis();
        System.out.println("Cache Elapsed Time is :" + (end - start));
        return order;
    }


    @GetMapping(path = "/item/{id}", produces = "application/json")
    @ResponseBody
    public Item getItem(@PathVariable("id") Integer id) {
        return amazonService.getItem(id);
    }

    @GetMapping(path = "/price/{id}", produces = "application/json")
    @ResponseBody
    public Price getPrice(@PathVariable("id") Integer id) {
        return amazonService.getPrice(id);
    }
}
