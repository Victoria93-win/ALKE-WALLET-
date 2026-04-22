package com.alkewallet.service;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterImpl implements CurrencyConverter {

    private Map<String, Double> rates = new HashMap<>();

    public CurrencyConverterImpl() {
        rates.put("CLP_USD", 0.0011);
        rates.put("USD_CLP", 900.0);
        rates.put("USD_EUR", 0.92);
        rates.put("EUR_USD", 1.08);
    }

    @Override
    public double convert(double amount, String from, String to) {
        String key = from + "_" + to;
        if (!rates.containsKey(key)) {
            throw new IllegalArgumentException("Conversión no soportada");
        }
        return amount * rates.get(key);
    }
}