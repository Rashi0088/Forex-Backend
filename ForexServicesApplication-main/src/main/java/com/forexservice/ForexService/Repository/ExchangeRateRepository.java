package com.forexservice.ForexService.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forexservice.ForexService.Entity.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer>{
	
	ExchangeRate save(ExchangeRate exchangeRate);

	ExchangeRate findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
	

	List<ExchangeRate> findByDate(LocalDate date);
	
//	To get rates by providing from currency and to currency

	List<ExchangeRate> findByFromCurrencyAndToCurrencyAndDate(String fromCurrency, String toCurrency, LocalDate date);

	  @Query("SELECT e.rate FROM ExchangeRate e WHERE e.fromCurrency = :fromCurrency AND e.toCurrency = :toCurrency")
	    Double findExchangeRateByCurrency(@Param("fromCurrency") String fromCurrency, @Param("toCurrency") String toCurrency);


}
