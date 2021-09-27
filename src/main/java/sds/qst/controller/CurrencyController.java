package sds.qst.controller;

import org.springframework.web.bind.annotation.*;
import sds.qst.repo.CurrencyRepo;
import sds.qst.entity.Currency;

import java.util.Map;

@RestController
@RequestMapping("currency")
class CurrencyController {
    private final CurrencyRepo currencyRepo;

    public CurrencyController(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @PostMapping
    public void add(@RequestBody Map<String, String> data) {
        Currency currency = new Currency(data.get("name"));

        currencyRepo.save(currency);
    }
}