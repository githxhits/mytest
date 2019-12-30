package com.huonghoang.mytest.repository;

import com.huonghoang.mytest.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    Currency findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
}
