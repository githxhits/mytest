package com.huonghoang.mytest;

import com.huonghoang.mytest.dto.request.CurrencyExchangeRequest;
import com.huonghoang.mytest.dto.response.CurrencyExchangeResponse;
import com.huonghoang.mytest.entity.Currency;
import com.huonghoang.mytest.exception.ResourceNotFoundException;
import com.huonghoang.mytest.repository.CurrencyRepository;
import com.huonghoang.mytest.service.impl.CurrencyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(JUnit4.class)
public class CurrencyServiceTest {

    @Mock
    private CurrencyRepository currencyRepository;

    private CurrencyServiceImpl  currencyService;

    @Before
    public void setUp() {
        initMocks(this);
        reset(currencyRepository);
        currencyService = new CurrencyServiceImpl(currencyRepository);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void shouldGetAllCurrentcy() throws ResourceNotFoundException {

        doReturn(new ArrayList<Currency>()).when(currencyRepository).findAll();
        List<Currency> TEST =  currencyService.findAll();
        assertNotNull(TEST);
    }

    @Test
    public void shouldGetAll1Currentcy() throws ResourceNotFoundException {
        Currency currency = new Currency();
        currency.setExchangeRate(new BigDecimal(0.74216));
        currency.setId(1L);
        currency.setSourceCurrency("SGD");
        currency.setTargetCurrency("USD");
        List<Currency> lists = Arrays.asList(currency);
        doReturn(lists).when(currencyRepository).findAll();
        List<Currency> TEST =  currencyService.findAll();
        assertNotNull(TEST);
    }

    @Test
    public void shouldGetSingleCurrentcy() throws ResourceNotFoundException {
        CurrencyExchangeRequest request = new CurrencyExchangeRequest();
        request.setMoney(new BigDecimal(19000));
        request.setSource("SGD");
        request.setTarget("USD");
        Currency currency = new Currency();
        currency.setExchangeRate(new BigDecimal(0.74216));
        currency.setId(1L);
        currency.setSourceCurrency("SGD");
        currency.setTargetCurrency("USD");
        doReturn(currency).when(currencyRepository).findBySourceCurrencyAndTargetCurrency(anyString(),anyString());
        CurrencyExchangeResponse TEST =  currencyService.exchange(request);
        assertNotNull(TEST);
    }

}
