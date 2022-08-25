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
	private Double thresholdValue;

	/**
	 * @param security
	 * @param price
	 * @param volume
	 */
	public TradingStrategy(@Value("${security}") String security, @Value("${price}")String price,@Value("${volume}") String volume, @Value("${thresholdValue}") String thresholdValue) {
		this.security = security;
		this.price = Double.valueOf(price);
		this.volume =Integer.valueOf(volume);
		this.thresholdValue=Double.valueOf(thresholdValue);
	}
    /**
	 * @param security
	 * @param price
	 */
	@Override
	public void priceUpdate(String security, double price) {
		if(price<this.thresholdValue)
			executionService.buy(this.security, this.price, this.volume);
	}

}
