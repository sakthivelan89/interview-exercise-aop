package com.acme.mytrader.price.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.acme.mytrader.strategy.TradingStrategy;

/**
 * Created by sakthivelan on 8/22/22.
 */
@SpringBootApplication
@ComponentScan("com.acme.mytrader")
@ComponentScan("com.acme.mytrader.strategy")
public class Application {

    public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
    }
}