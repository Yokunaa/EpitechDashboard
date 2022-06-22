package com.example.dashboard.controllers;

import com.posadskiy.currencyconverter.CurrencyConverter;
import com.posadskiy.currencyconverter.config.ConfigBuilder;
import com.posadskiy.currencyconverter.enums.Currency;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    /**
     * Define your API keys
     * Use at least one key, but we recommend define three:
     * One or even two services can be off, but not three at the same time
     */
    public static final String CURRENCY_LAYER = "3493ac332e862b7877906d359c59cc96";
    @RequestMapping("/exchange/{first}/{second}")
    public Double exchanger(@PathVariable("first") String first,@PathVariable("second") String second){
        CurrencyConverter converter = new CurrencyConverter(
                new ConfigBuilder()
                        .currencyLayerApiKey(CURRENCY_LAYER)
                        .build()
        );

        Double usdToEuroRate = converter.rate(first, second);
        System.out.println(usdToEuroRate);
        return  usdToEuroRate;
    }

}
