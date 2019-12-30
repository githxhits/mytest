package com.huonghoang.mytest.dto.response;

import java.math.BigDecimal;

public class CurrencyExchangeResponse {

    private Long id;
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal money;
    private BigDecimal totalMoneyAmount;

    public CurrencyExchangeResponse(Long id, String sourceCurrency, String targetCurrency, BigDecimal exchangeRate, BigDecimal money, BigDecimal totalMoneyAmount) {
        this.id = id;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
        this.money = money;
        this.totalMoneyAmount = totalMoneyAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotalMoneyAmount() {
        return totalMoneyAmount;
    }

    public void setTotalMoneyAmount(BigDecimal totalMoneyAmount) {
        this.totalMoneyAmount = totalMoneyAmount;
    }
}
