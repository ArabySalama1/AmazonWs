package com.integrant.amazonws;

import com.integrant.amazonws.dao.CustomerRepository;
import com.integrant.amazonws.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmbededRedisTestConfiguration.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldSaveUser_toRedis() {
        System.out.println("#################First time##############");
        long start = System.currentTimeMillis();
        List<Customer> list = customerRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("First Elapsed Time is " + (end - start));

        System.out.println("#################Second time##############");
        start = System.currentTimeMillis();
        list = customerRepository.findAll();
        end = System.currentTimeMillis();
        System.out.println("Second Elapsed Time is " + (end - start));


    }
}
