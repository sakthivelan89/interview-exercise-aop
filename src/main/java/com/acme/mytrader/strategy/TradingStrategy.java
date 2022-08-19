package com.acme.mytrader.strategy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.mytrader.execution.ExecutionService;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
@Aspect
@Component
public class TradingStrategy {
	
	@Autowired
	ExecutionService executionService;
	@After("execution (* com.acme.mytrader.price.impl.PriceListenerImpl.priceUpdate(*,*)) && args(security,price)")
	   public void afterReturningAdvice(String security,double price) throws Throwable {
		
		switch(security) {
		case "TCS":
			if(price>55.0)
				executionService.sell(security, price, 100);
			else
				executionService.buy(security, price, 100);
		}
		
	}
}
