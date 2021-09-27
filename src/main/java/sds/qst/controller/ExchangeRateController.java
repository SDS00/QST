package sds.qst.controller;

import org.springframework.web.bind.annotation.*;
import sds.qst.entity.Currency;
import sds.qst.entity.ExchangeRate;
import sds.qst.repo.CurrencyRepo;
import sds.qst.repo.ExchangeRateRepo;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("exchange_rate")
public class ExchangeRateController {
    private final ExchangeRateRepo exchangeRateRepo;
    private final CurrencyRepo currencyRepo;

    public ExchangeRateController(ExchangeRateRepo exchangeRateRepo, CurrencyRepo currencyRepo) {
        this.exchangeRateRepo = exchangeRateRepo;
        this.currencyRepo = currencyRepo;
    }

    @GetMapping("{from_id}/{to_id}")
    public List<ExchangeRate> getExchangeRate(
            @PathVariable("from_id") Currency fromCurrency,
            @PathVariable("to_id") Currency toCurrency
    ) {
        return exchangeRateRepo.getByFromAndTo(fromCurrency, toCurrency);
    }

    @PostMapping
    public void add(@RequestBody Map<String, String> data) {
        Currency fromCurrency = currencyRepo.getById(Long.parseLong(data.get("from_id")));
        Currency toCurrency = currencyRepo.getById(Long.parseLong(data.get("to_id")));
        double value = Double.parseDouble(data.get("value"));
        Date date = new Date(Long.parseLong(data.get("date")));

        ExchangeRate exchangeRate = new ExchangeRate(fromCurrency, toCurrency, value, date);

        exchangeRateRepo.save(exchangeRate);
    }
}
