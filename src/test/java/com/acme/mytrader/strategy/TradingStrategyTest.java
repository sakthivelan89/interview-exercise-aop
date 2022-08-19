package com.acme.mytrader.strategy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mock;

import com.acme.mytrader.execution.ExecutionService;

public class TradingStrategyTest {
    @Test
    public void testNothing() {
    }
    @Mock
    private TradingStrategy tStrategy;
    
    @Mock
    ExecutionService eService;
    

    @Test
    public void testTCSBuyScenario() throws Throwable {
    	
        doNothing().when(tStrategy).afterReturningAdvice("TCS", 50.0);
        verify(eService, times(1)).buy("TCS",50.0,100);

    }

    @Test
    public void testTCSSellScenario() throws Throwable {
    	 doNothing().when(tStrategy).afterReturningAdvice("TCS", 60.0);
         verify(eService, times(1)).sell("TCS",60.0,100);
    }
}
