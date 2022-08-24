package com.acme.mytrader.price.main;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.impl.PriceListenerImpl;

/**
 * Created by sakthivelan on 8/24/22.
 */
@SpringBootApplication
@ComponentScan("com.acme.mytrader")
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ac = SpringApplication.run(Application.class, args);  
        System.out.println("Bean names: " + Arrays.toString(ac.getBeanNamesForType(PriceListenerImpl.class)));

        PriceListener priceListener = ac.getBean(PriceListenerImpl.class);  

        priceListener.priceUpdate("TCS",54);  
      

    }
}
