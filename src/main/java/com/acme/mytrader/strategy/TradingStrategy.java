package com.acme.mytrader.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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
	private String security;
	private Double price;
	private int volume;





	/**
	 * @param security
	 * @param price
	 * @param volume
	 */
	public TradingStrategy(@Value("${security}") String security, @Value("${price}")String price,@Value("${volume}") String volume) {
		super();
		this.security = security;
		this.price = Double.valueOf(price);
		this.volume =Integer.valueOf(volume);
	}





	@Override
	public void priceUpdate(String security, double price) {
		switch(security) {
		case "TCS":
			if(price>55.0)
				executionService.sell(this.security, this.price, this.volume);
			else
				executionService.buy(this.security, this.price, this.volume);
		}
	}

}
