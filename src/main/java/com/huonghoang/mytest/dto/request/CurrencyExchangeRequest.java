package com.huonghoang.mytest.dto.request;

import java.math.BigDecimal;

public class CurrencyExchangeRequest {

    private String source;
    private String target;
    private BigDecimal money;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
