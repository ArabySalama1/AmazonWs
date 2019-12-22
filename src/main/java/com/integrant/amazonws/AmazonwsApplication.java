package com.integrant.amazonws;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;


@SpringBootApplication
@ComponentScan("com.integrant")
@EnableCaching
public class AmazonwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonwsApplication.class, args);
        //To register EH-cache in Java-console
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        CacheManager cacheMgr = CacheManager.getInstance();
        ManagementService.registerMBeans(cacheMgr, mbs, true, true, true, true);
    }

}
