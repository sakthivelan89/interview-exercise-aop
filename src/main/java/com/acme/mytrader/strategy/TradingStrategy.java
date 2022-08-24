package com.acme.mytrader.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
@Service
public class TradingStrategy implements PriceListener {
	
	//@Autowired
	//Autowired should be enabled once the component service is available for executionservice
	ExecutionService executionService;
	//This will be changed according to buy implementation. This should come from buy.
	Map securityPriceList = new HashMap<String, Double>();
	
	@Override
	public void priceUpdate(String security, double price) {
		securityPriceList.put(security, price);
		switch(security) {
		case "TCS":
			if(price>55.0)
				executionService.sell(security, price, 100);
			else
				executionService.buy(security, price, 100);
		}
	}
}
