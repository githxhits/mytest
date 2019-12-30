package com.huonghoang.mytest.service.impl;

import com.huonghoang.mytest.dto.request.CurrencyExchangeRequest;
import com.huonghoang.mytest.dto.response.CurrencyExchangeResponse;
import com.huonghoang.mytest.entity.Currency;
import com.huonghoang.mytest.exception.ResourceNotFoundException;
import com.huonghoang.mytest.repository.CurrencyRepository;
import com.huonghoang.mytest.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> findAll() throws ResourceNotFoundException {
        List<Currency> all = currencyRepository.findAll();
        if (CollectionUtils.isEmpty(all)) {
            throw new ResourceNotFoundException("List currency is empty");
        }
        return all;
    }

    @Override
    public CurrencyExchangeResponse exchange(CurrencyExchangeRequest currencyExchangeRequest) throws ResourceNotFoundException {
        Currency currency = currencyRepository.findBySourceCurrencyAndTargetCurrency(currencyExchangeRequest.getSource(), currencyExchangeRequest.getTarget());
        if (null == currency) {
            throw new ResourceNotFoundException("currency not found");
        }
        CurrencyExchangeResponse response = new CurrencyExchangeResponse(currency.getId(), currency.getSourceCurrency(), currency.getTargetCurrency(),
                currency.getExchangeRate(), currencyExchangeRequest.getMoney(), currencyExchangeRequest.getMoney().multiply(currency.getExchangeRate()));
        return response;
    }
}
