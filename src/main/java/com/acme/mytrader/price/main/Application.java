package com.acme.mytrader.price.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.strategy.TradingStrategy;

/**
 * Created by sakthivelan on 8/22/22.
 */
@SpringBootApplication
@ComponentScan("com.acme.mytrader")
public class Application {

    public static void main(String[] args) {

      ConfigurableApplicationContext ac = SpringApplication.run(Application.class, args);  
      PriceListener priceListener = ac.getBean(TradingStrategy.class);  
      priceListener.priceUpdate("TCS",54);  
      

    }
}
