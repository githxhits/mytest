package com.huonghoang.mytest.service;

import com.huonghoang.mytest.dto.request.CurrencyExchangeRequest;
import com.huonghoang.mytest.dto.response.CurrencyExchangeResponse;
import com.huonghoang.mytest.entity.Currency;
import com.huonghoang.mytest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {

    List<Currency> findAll() throws ResourceNotFoundException;

    CurrencyExchangeResponse exchange(CurrencyExchangeRequest currencyExchangeRequest) throws ResourceNotFoundException;
}
