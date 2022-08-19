package com.acme.mytrader.price.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.acme.mytrader.price.PriceListener;

@Service
public class PriceListenerImpl implements PriceListener{
	public Map<String,Double> securityPriceList=new HashMap();

	@Override
	public void priceUpdate(String security, double price) {
		securityPriceList.put(security, price);
	}
}
