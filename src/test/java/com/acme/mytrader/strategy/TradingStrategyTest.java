package com.acme.mytrader.strategy;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.mytrader.execution.ExecutionService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application.properties")
public class TradingStrategyTest {

    @Mock
    private TradingStrategy tStrategy;

    @Mock
    ExecutionService eService;

    @Value("${security}")
    String security;

    @Value("${price}")
    String price;

    @Value("${volume}")
    String volume;

    @Value("${thresholdValue}")
    String thresholdValue;

    @Test
    public void testBuyScenario() throws Throwable {
        doNothing().when(tStrategy).priceUpdate(security, Double.valueOf(price));
        assertTrue(Double.valueOf(price)<Double.valueOf(thresholdValue));
        eService.buy(security, Double.valueOf(price), Integer.valueOf(volume));
        verify(eService, atLeastOnce()).buy(anyString(),anyDouble(),anyInt());
    }

}

