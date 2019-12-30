package com.huonghoang.mytest.controller;

import com.huonghoang.mytest.dto.request.CurrencyExchangeRequest;
import com.huonghoang.mytest.dto.response.CurrencyExchangeResponse;
import com.huonghoang.mytest.entity.Currency;
import com.huonghoang.mytest.exception.ResourceNotFoundException;
import com.huonghoang.mytest.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Currency>> getAll() throws ResourceNotFoundException {
        List<Currency> all = currencyService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/exchange", method = RequestMethod.POST)
    public ResponseEntity<CurrencyExchangeResponse> getCurrency(@RequestBody(required = true) CurrencyExchangeRequest currencyExchangeRequest) throws ResourceNotFoundException {
        CurrencyExchangeResponse response = currencyService.exchange(currencyExchangeRequest);
        return new ResponseEntity<CurrencyExchangeResponse>(response, HttpStatus.OK);
    }
}
