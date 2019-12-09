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

    @GetMapping(path = "/customer", produces = "application/json")
    @ResponseBody
    public Customer getCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> list = amazonService.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Customer Elapsed Time is :" + (end - start));
        return list.get(0);
    }

   /* @GetMapping(path = "/customer", produces = "application/json")
    @ResponseBody
    public Customer getCustomer() {
        long start = System.currentTimeMillis();
        Customer customer=amazonService.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Customer Elapsed Time is :"+ (end-start) );
        return customer;
    }*/

    @GetMapping(path = "/order/{id}", produces = "application/json")
    @ResponseBody
    public Order getOrder(@PathVariable("id") Integer id) {
        return amazonService.getOrder(id);
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
